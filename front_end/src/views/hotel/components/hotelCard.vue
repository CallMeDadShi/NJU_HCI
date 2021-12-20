<template>
<!--  <a-card hoverable class="hotelCard ant-col-xs-7 ant-col-lg-5 ant-col-xxl-3">-->
<!--    <img-->
<!--            alt="example"-->
<!--            :src="hotelUrl.url"-->
<!--            slot="cover"-->
<!--            referrerPolicy="no-referrer"-->
<!--    />-->
<!--    <a-tooltip :title="hotel.title" placement="top">-->
<!--      <a-card-meta :title="hotel.name">-->
<!--        <template slot="description">-->
<!--          <a-rate style="font-size: 15px" :value="hotel.hotelStar" disabled allowHalf/>-->
<!--          <a-popover title="好评如潮">-->
<!--            <template slot="content">-->
<!--              <p>2点评</p>-->
<!--            </template>-->
<!--            <a-button type="primary" ghost>-->
<!--              {{hotel.rate}}分-->
<!--            </a-button>-->
<!--          </a-popover>-->
<!--        </template>-->
<!--      </a-card-meta>-->
<!--    </a-tooltip>-->
<!--  </a-card>-->
    <v-card
        :loading="loading"
        class="hotelCard"
        max-width="370"
    >
      <template slot="progress">
        <v-progress-linear
            color="deep-purple"
            height="15"
            indeterminate
        ></v-progress-linear>
      </template>

      <v-img
          height="250"
          :src="hotelUrl.url"
      ></v-img>

      <v-card-title>{{ hotel.name }}</v-card-title>

      <v-card-text>
        <v-row
            align="center"
            class="mx-0"
            style="font-size: 15px;"
        >
          <a-rate style="font-size: 9px;margin-left: 10px" :value="hotel.hotelStar" disabled allowHalf />
          <div class="grey--text ms-4">
            {{ hotel.rate}}
          </div>
        </v-row>

        <div class="description" style="margin-top: 20px" align="left">
          {{hotel.description}}
        </div>
      </v-card-text>

      <v-divider class="mx-4"></v-divider>



      <v-card-actions>
        <v-card-title class=" font-weight-black">今日特惠¥500</v-card-title>
        <v-btn
            class="ma-2"
            outlined
            style="margin-left: 20px;color: royalblue"
            @click="jumpToDetails(hotel.id)"
        >
          查看详情
        </v-btn>
      </v-card-actions>
    </v-card>
</template>
<script>
  import {mapGetters} from "vuex";

  export default {
    name:'',
    props: {
      hotelUrl:{},
      hotel: {}
    },
    data() {
      return{

      }
    },
    computed: {
      ...mapGetters([
        'userId',
        'currentHotelInfo',
        'userInfo',
        'currentHotelId',
        'currentHotelUrl',
        'roomList',
        'historyOrderList',
      ]),
      image_url: function () {
        // return "https://test-nju-1.oss-cn-shenzhen.aliyuncs.com/hotel/timg.png"
        return this.currentHotelUrl
      },
    },
    methods: {
      jumpToDetails(id){
        this.$router.push({ name: 'hotelDetail', params: { hotelId: id }})
      },
    }
  }
</script>
<style scoped lang="less">
  .hotelCard {
    margin: 10px 10px;
    min-width: 370px;
    min-height: 480px;
    img {
      height: 250px;
    }
  }
  .description{
    color: dimgrey;
    display: -webkit-box;/*作为弹性伸缩盒子模型显示*/
    -webkit-line-clamp: 1; /*显示的行数；如果要设置2行加...则设置为2*/
    overflow: hidden; /*超出的文本隐藏*/
    text-overflow: ellipsis; /* 溢出用省略号*/
    -webkit-box-orient: vertical;/*伸缩盒子的子元素排列：从上到下*/
  }
  .font-weight-black{
    color: dodgerblue;
  }
</style>

<style lang="less">
  .hotelCard{
    .ant-card-body{
      padding: 12px
    }
  }

  .ant-card-hoverable:hover {
    box-shadow: 0 2px 8px rgba(0,0,0,0.4)
  }

</style>