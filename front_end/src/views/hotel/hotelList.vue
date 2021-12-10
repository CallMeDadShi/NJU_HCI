<template>
  <div class="hotelList">
    <a-input-search
        placeholder="请输入酒店名字或者是地址"
        enter-button="Search"
        style="width: 90%; margin-bottom: 50px;"
        @search="onSearch"
    />
    <div>
      <transition
          enter-active-class="animate__animated animate__fadeIn"
          leave-active-class="animate__animated animate__fadeOut"
      >
        <div class="fixedSearch" v-show="showFixedSearch">
          <a-input-group size="large">
          <a-row :gutter="10">
            <a-col :span="4">
              <div style="margin-left: 50px">
                <p><b>请输入酒店名字</b></p>
                <a-input placeholder="请输入酒店名字" v-model="hotel_name" />
              </div>
            </a-col>
            <a-col :span="4">
              <div>
                <p><b>请输入酒店地址</b></p>
                <a-input placeholder="请输入酒店地址" v-model="hotel_address"/>
              </div>
            </a-col>
            <a-col :span="4">
              <div>
                <p><b>入住时间</b></p>
                <a-range-picker
                    format="YYYY-MM-DD"
                    v-decorator="[
                        'date',
                        {
                            rules: [{ required: true, message: '请选择入住时间' }]
                        }
                    ]"
                    :placeholder="['入住日期','退房日期']"
                />
              </div>
            </a-col>
            <a-col :span="4">
              <p><b>
                请选择星级
                </b></p>
              <a-dropdown trigger="['click']">
                <p><a-rate :default-value="2" disabled /> <a-icon type="down" /></p>
                <template #overlay>
                  <a-menu>
                    <a-menu-item>
                      最低星级:<a-rate v-model="value_low_rate" />
                    </a-menu-item>
                    <a-menu-item>
                      最高星级:<a-rate v-model="value_high_rate" />
                    </a-menu-item>
                  </a-menu>
                </template>
              </a-dropdown>
            </a-col>
            <a-col :span="4">
              <p><b>请选择价格区间</b></p>
              <a-slider range :marks="marks" :default-value="[100, 500]" :min="0" :max="2000" @change="getMoney" style="margin-top: 20px"/>
            </a-col>
            <a-col :span="4">
              <a-button type="primary" icon="search" style="margin-left:-20px; margin-top: 35px" @click="searchFunc">
                查找
              </a-button>
            </a-col>
          </a-row>

          </a-input-group>
        </div>
      </transition>
    </div>

    <a-layout>
        <a-layout-content style="min-width: 800px">
          <a-spin :spinning="hotelListLoading">

              <div class="temp">
                  <coupon-active :file-list1="fileList"></coupon-active></div>
              <div style="width: 100%;">
                  <div style="width: 100%; text-align: right; margin:20px 0">
                      <select-menu style=" margin-right: 50px"  >详细搜索</select-menu>
                  </div>

              </div>
            <div class="card-wrapper">

                <HotelCard :hotel="item" :hotel-url="getUrl(item)" v-for="item in hotelList" :key="item.index" @click.native="jumpToDetails(item.id)"></HotelCard>
                <div v-for="item in emptyBox" :key="item.name" class="emptyBox ant-col-xs-7 ant-col-lg-5 ant-col-xxl-3">
                </div>
                <a-pagination showQuickJumper :total="hotelList.totalElements" :defaultCurrent="1" @change="pageChange"></a-pagination>
            </div>

          </a-spin>
      </a-layout-content>
    </a-layout>
  </div>
</template>
<script>
import HotelCard from './components/hotelCard'
import { mapGetters, mapActions, mapMutations } from 'vuex'
import Coupon from "../hotelManager/components/coupon";
 import CouponActive from "./components/couponActive";
import SelectMenu from "./components/selectMenu";
import animate from "animate.css";
import { Moment } from 'moment';
import { SearchOutlined,DownOutlined } from '@ant-design/icons-vue';

export default {
  name: 'home',
  components: {
      SelectMenu,
      CouponActive,
      // Coupon,
    HotelCard
  },
  data(){
    return{
      emptyBox: [{ name: 'box1' }, { name: 'box2'}, {name: 'box3'}],
      showFixedSearch: false,
      value_low_rate:1,
      value_high_rate:5,
      dropdownvisible:false,
      money1:100,
      money2:500,
      marks: {
        0: '0',
        100: '100',
        500: '500',
        2000: {
          style: {
            color: '#f50',
          },
          label: '2000',
        }
      },
      hotel_name:"",
      hotel_address:""
    }
  },
  async mounted() {
    window.addEventListener("scroll", this.showSearch)
    await this.getHotelList()
      await this.getHotelUrlList()
      await this.getFileList()
  },
  computed: {
    ...mapGetters([
      'hotelList',
      'hotelListLoading',
        'fileList',
        'hotelUrlList'
    ])
  },
  methods: {
    ...mapMutations([
      'set_hotelListParams',
      'set_hotelListLoading'
    ]),
    ...mapActions([
      'getHotelList',
        'getFileList',
        'searchHotel',
        'getHotelUrlList',
      'getHotelMatch',
    ]),
    showSearch() {
      // 获取当前滚动条向下滚动的距离
      let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
      // 当页面滚动到高度300px处时，显示搜索框
      if (scrollTop > 100) {
        this.showFixedSearch = true;
      } else {
        this.showFixedSearch = false;
      }
    },
      getUrl(item){
        for(var i=0;i<this.hotelUrlList.length;i++){
            if(item.id==this.hotelUrlList[i].id){return this.hotelUrlList[i]}
        }
        return {url:require("@/assets/cover.jpeg")}
      },
    pageChange(page, pageSize) {
      const data = {
        pageNo: page - 1
      }
      this.set_hotelListParams(data)
      this.set_hotelListLoading(true)
      this.getHotelList()
    },
    jumpToDetails(id){
      this.$router.push({ name: 'hotelDetail', params: { hotelId: id }})
    },
      onSearch(value){

        this.searchHotel(value)
    },
    getMoney(value){
      this.money1=value[0]
      this.money2=value[1]
      console.log(value)
    },
    searchFunc(){
      const data = {
        name: this.hotel_name,
        address: this.hotel_address,
        rate:[0,5],
        money:[this.money1,this.money2],
        hotelStar:[this.value_low_rate,this.value_high_rate]
      }
      this.getHotelMatch(data)
    }
  }
}
</script>
<style scoped lang="less">
  .hotelList {
    text-align: center;
    padding: 50px 0;
    .emptyBox {
      height: 0;
      margin: 10px 10px
    }
    .card-wrapper{
      display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
        flex-grow: 3;
        min-height: 800px
    }
    .card-wrapper .card-item {
      margin: 30px;
      position: relative;
      height: 188px;
    }
      .temp{
          text-align: center;
          width: 70%;
          margin-left: auto;
          margin-right: auto;

      }
  }
  .fixedSearch {
    position: fixed;
    top: 0px;
    left: 10px;
    right: 10px;
    width: 100%;
    background-color: white;
    z-index: 999;
    height: 120px;
    overflow: auto;
  }
</style>
