<template>
  <div class="hotelList">
    <a-input-search
        placeholder="请输入酒店名字或者是地址"
        enter-button="Search"
        style="width: 90%; margin-bottom: 50px;"
        @search="onSearch"
    />

    <div class="top-filter-container" style="padding-bottom: 30px;border: 0" >
      <a-list item-layout="horizontal" bordered="true">
        <a-list-item style="padding: 0">
          <div style="background-color:#F0F2F5;width: 20%; border-right:1px solid #D9D9D9">
            <b>位置区域</b>
          </div>
          <div style="background-color: white;width: 80%">
            <a-tabs size="small" default-active-key="6" style="padding-bottom: 20px;">
              <a-tab-pane key="1" tab="热门筛选">
                <div>
                  <a-checkable-tag id="t1" v-model="checkremen[0]" @change="tagClick('t1')" style="background-color: #F0F2F5">
                    新街口
                  </a-checkable-tag>
                  <a-checkable-tag id="t2" v-model="checkremen[1]" @change="tagClick('t2')" style="background-color: #F0F2F5">
                    夫子庙景区/秦淮河风光区
                  </a-checkable-tag>
                  <a-checkable-tag id="t3" v-model="checkremen[2]" @change="tagClick('t3')" style="background-color: #F0F2F5">
                    南京南站
                  </a-checkable-tag>
                  <a-checkable-tag id="t4" v-model="checkremen[3]" @change="tagClick('t4')" style="background-color: #F0F2F5">
                    汤山风景区
                  </a-checkable-tag>
                  <a-checkable-tag id="t5" v-model="checkremen[4]" @change="tagClick('t5')" style="background-color: #F0F2F5">
                    江宁区
                  </a-checkable-tag>
                  <a-checkable-tag id="t6" v-model="checkremen[5]" @change="tagClick('t6')" style="background-color: #F0F2F5">
                    禄口国际机场
                  </a-checkable-tag>
                  <a-checkable-tag id="t7" v-model="checkremen[6]" @change="tagClick('t7')" style="background-color: #F0F2F5">
                    南京大学（鼓楼校区）
                  </a-checkable-tag>
                  <a-checkable-tag id="t8" v-model="checkremen[7]" @change="tagClick('t8')" style="background-color: #F0F2F5">
                    玄武湖
                  </a-checkable-tag>
                </div>
              </a-tab-pane>
              <a-tab-pane key="2" tab="商业区">
                <a-checkable-tag id="sy1" v-model="checksy[0]" @change="tagClick('sy1')" style="background-color: #F0F2F5">
                  新街口
                </a-checkable-tag>
                <a-checkable-tag id="sy2" v-model="checksy[1]" @change="tagClick('sy2')" style="background-color: #F0F2F5">
                  汤山风景区
                </a-checkable-tag>
                <a-checkable-tag id="sy3" v-model="checksy[2]" @change="tagClick('sy3')" style="background-color: #F0F2F5">
                  玄武湖
                </a-checkable-tag>
                <a-checkable-tag id="sy4" v-model="checksy[3]" @change="tagClick('sy4')" style="background-color: #F0F2F5">
                  江宁开发区
                </a-checkable-tag>
                <a-checkable-tag id="sy5" v-model="checksy[4]" @change="tagClick('sy5')" style="background-color: #F0F2F5">
                  徐庄软件园
                </a-checkable-tag>
                <a-checkable-tag id="sy6" v-model="checksy[5]" @change="tagClick('sy6')" style="background-color: #F0F2F5">
                  奥体中心
                </a-checkable-tag>
              </a-tab-pane>
              <a-tab-pane key="3" tab="机场车站">
                <div>
                  <a-checkable-tag id="jcdt1" v-model="checkjcdt[0]" @change="tagClick('jcdt1')" style="background-color: #F0F2F5">
                    南京南站
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt2" v-model="checkjcdt[1]" @change="tagClick('jcdt2')" style="background-color: #F0F2F5">
                    禄口国际机场
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt3" v-model="checkjcdt[2]" @change="tagClick('jcdt3')" style="background-color: #F0F2F5">
                    南京火车站
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt4" v-model="checkjcdt[3]" @change="tagClick('jcdt4')" style="background-color: #F0F2F5">
                    溧水站
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt5" v-model="checkjcdt[4]" @change="tagClick('jcdt5')" style="background-color: #F0F2F5">
                    江宁站
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt6" v-model="checkjcdt[5]" @change="tagClick('jcdt6')" style="background-color: #F0F2F5">
                    仙林高铁站
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt7" v-model="checkjcdt[6]" @change="tagClick('jcdt7')" style="background-color: #F0F2F5">
                    栖霞山站
                  </a-checkable-tag>
                  <a-checkable-tag id="jcdt8" v-model="checkjcdt[7]" @change="tagClick('jcdt8')" style="background-color: #F0F2F5">
                    西善桥站
                  </a-checkable-tag>
                </div>
              </a-tab-pane>
              <a-tab-pane key="5" tab="行政区">
                <div>
                  <a-checkable-tag id="xz1" v-model="checkxz[0]" @change="tagClick('xz1')" style="background-color: #F0F2F5">
                    六合区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz2" v-model="checkxz[1]" @change="tagClick('xz2')" style="background-color: #F0F2F5">
                    建邺区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz3" v-model="checkxz[2]" @change="tagClick('xz3')" style="background-color: #F0F2F5">
                    栖霞区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz4" v-model="checkxz[3]" @change="tagClick('xz4')" style="background-color: #F0F2F5">
                    江宁区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz5" v-model="checkxz[4]" @change="tagClick('xz5')" style="background-color: #F0F2F5">
                    浦口区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz6" v-model="checkxz[5]" @change="tagClick('xz6')" style="background-color: #F0F2F5">
                    溧水区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz7" v-model="checkxz[6]" @change="tagClick('xz7')" style="background-color: #F0F2F5">
                    玄武区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz8" v-model="checkxz[7]" @change="tagClick('xz8')" style="background-color: #F0F2F5">
                    秦淮区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz9" v-model="checkxz[8]" @change="tagClick('xz9')" style="background-color: #F0F2F5">
                    雨花台区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz10" v-model="checkxz[9]" @change="tagClick('xz10')" style="background-color: #F0F2F5">
                    高淳区
                  </a-checkable-tag>
                  <a-checkable-tag id="xz11" v-model="checkxz[10]" @change="tagClick('xz11')" style="background-color: #F0F2F5">
                    秦淮河
                  </a-checkable-tag>
                  <a-checkable-tag id="xz12" v-model="checkxz[11]" @change="tagClick('xz12')" style="background-color: #F0F2F5">
                    鼓楼区
                  </a-checkable-tag>
                </div>
              </a-tab-pane>
              <a-tab-pane key="6" tab="景点">
                <div>
                  <a-checkable-tag id="jd1" v-model="checkjd[0]" @change="tagClick('jd1')" style="background-color: #F0F2F5">
                    新街口
                  </a-checkable-tag>
                  <a-checkable-tag id="jd2" v-model="checkjd[1]" @change="tagClick('jd2')" style="background-color: #F0F2F5">
                    汤山风景区
                  </a-checkable-tag>
                  <a-checkable-tag id="jd3" v-model="checkjd[2]" @change="tagClick('jd3')" style="background-color: #F0F2F5">
                    玄武湖
                  </a-checkable-tag>
                  <a-checkable-tag id="jd4" v-model="checkjd[3]" @change="tagClick('jd4')" style="background-color: #F0F2F5">
                    中山陵景区
                  </a-checkable-tag>
                  <a-checkable-tag id="jd5" v-model="checkjd[4]" @change="tagClick('jd5')" style="background-color: #F0F2F5">
                    栖霞山
                  </a-checkable-tag>
                  <a-checkable-tag id="jd6" v-model="checkjd[5]" @change="tagClick('jd6')" style="background-color: #F0F2F5">
                    南京总统府
                  </a-checkable-tag>
                  <a-checkable-tag id="jd7" v-model="checkjd[6]" @change="tagClick('jd7')" style="background-color: #F0F2F5">
                    钟山风景名胜区
                  </a-checkable-tag>
                  <a-checkable-tag id="jd8" v-model="checkjd[7]" @change="tagClick('jd8')" style="background-color: #F0F2F5">
                    老东门历史街区
                  </a-checkable-tag>
                  <a-checkable-tag id="jd9" v-model="checkjd[8]" @change="tagClick('jd9')" style="background-color: #F0F2F5">
                    夫子庙
                  </a-checkable-tag>
                  <a-checkable-tag id="jd10" v-model="checkjd[9]" @change="tagClick('jd10')" style="background-color: #F0F2F5">
                    南京博物馆
                  </a-checkable-tag>
                  <a-checkable-tag id="jd11" v-model="checkjd[10]" @change="tagClick('jd11')" style="background-color: #F0F2F5">
                    秦淮河
                  </a-checkable-tag>
                  <a-checkable-tag id="jd12" v-model="checkjd[11]" @change="tagClick('jd12')" style="background-color: #F0F2F5">
                    牛首山景区
                  </a-checkable-tag>
                </div>
              </a-tab-pane>
            </a-tabs>
          </div>
        </a-list-item>
        <a-list-item style="padding: 0">
          <div style="background-color:#F0F2F5;width: 20%; border-right:1px solid #D9D9D9">
            <b>星级价格</b>
          </div>
          <div style="background-color: white;width: 80%">
            <div style="padding-bottom: 20px;padding-top: 20px;">
              <a-checkable-tag id="xj1" v-model="checkxj[0]" @change="tagClick('xj1')" style="background-color: #F0F2F5">
                五星(钻)级
              </a-checkable-tag>
              <a-checkable-tag id="xj2" v-model="checkxj[1]" @change="tagClick('xj2')" style="background-color: #F0F2F5">
                四星(钻)级
              </a-checkable-tag>
              <a-checkable-tag id="xj3" v-model="checkxj[2]" @change="tagClick('xj3')" style="background-color: #F0F2F5">
                三星(钻)级
              </a-checkable-tag>
              <a-checkable-tag id="xj4" v-model="checkxj[3]" @change="tagClick('xj4')" style="background-color: #F0F2F5">
                150以下
              </a-checkable-tag>
              <a-checkable-tag id="xj5" v-model="checkxj[4]" @change="tagClick('xj5')" style="background-color: #F0F2F5">
                150-300
              </a-checkable-tag>
              <a-checkable-tag id="xj6" v-model="checkxj[5]" @change="tagClick('xj6')" style="background-color: #F0F2F5">
                300-450
              </a-checkable-tag>
              <a-checkable-tag id="xj7" v-model="checkxj[6]" @change="tagClick('xj7')" style="background-color: #F0F2F5">
                450-600
              </a-checkable-tag>
              <a-checkable-tag id="xj8" v-model="checkxj[7]" @change="tagClick('xj8')" style="background-color: #F0F2F5">
                600以上
              </a-checkable-tag>
            </div>
          </div>
        </a-list-item>
        <a-list-item style="padding: 0">
          <div style="background-color:#F0F2F5;width: 20%; border-right:1px solid #D9D9D9">
            <b>高级筛选</b>
          </div>
          <div class="high-level-select-container" style="display: flex;flex-direction: column;width: 80%">
            <div class="folder-high-level-select" style="background-color: white;display: flex;flex-direction: row;padding-top: 20px;padding-right: 5px">
              <div style="width: 10%;">
                <p>评分
                  <a-icon type="down" v-if="fold!=='pf'" @click="unfold('pf')"/>
                  <a-icon type="up" v-if="fold=='pf'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>点评数量
                  <a-icon type="down" v-if="fold!=='dp'" @click="unfold('dp')"/>
                  <a-icon type="up" v-if="fold=='dp'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>早餐
                  <a-icon type="down" v-if="fold!=='zc'" @click="unfold('zc')"/>
                  <a-icon type="up" v-if="fold=='zc'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>支付方式
                  <a-icon type="down" v-if="fold!=='zf'" @click="unfold('zf')"/>
                  <a-icon type="up" v-if="fold=='zf'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>房型
                  <a-icon type="down" v-if="fold!=='fx'" @click="unfold('fx')"/>
                  <a-icon type="up" v-if="fold=='fx'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>酒店设施
                  <a-icon type="down" v-if="fold!=='ss'" @click="unfold('ss')"/>
                  <a-icon type="up" v-if="fold=='ss'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>优惠促销
                  <a-icon type="down" v-if="fold!=='yh'" @click="unfold('yh')"/>
                  <a-icon type="up" v-if="fold=='yh'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>酒店类型
                  <a-icon type="down" v-if="fold!=='lx'" @click="unfold('lx')"/>
                  <a-icon type="up" v-if="fold=='lx'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>特色主题
                  <a-icon type="down" v-if="fold!=='zt'" @click="unfold('zt')"/>
                  <a-icon type="up" v-if="fold=='zt'" @click="unfold('none')"/>
                </p>
              </div>
              <div style="width: 10%">
                <p>品牌
                  <a-icon type="down" v-if="fold!=='pp'" @click="unfold('pp')"/>
                  <a-icon type="up" v-if="fold=='pp'" @click="unfold('none')"/>
                </p>
              </div>


            </div>
            <div class="tags-high-level-select" style="background-color: white;display: flex;flex-direction: row;padding-bottom: 20px">
              <div class="tas-pf" style="padding-left: 30px" v-if="fold=='pf'">
                <a-checkable-tag id="pf1" v-model="checkpf[0]" @change="tagClick('pf1')" style="background-color: #F0F2F5">
                  4.8分以上
                </a-checkable-tag>
                <a-checkable-tag id="pf2" v-model="checkpf[1]" @change="tagClick('pf2')" style="background-color: #F0F2F5">
                  4.5分以上
                </a-checkable-tag>
                <a-checkable-tag id="pf3" v-model="checkpf[2]" @change="tagClick('pf3')" style="background-color: #F0F2F5">
                  4.0分以上
                </a-checkable-tag>
                <a-checkable-tag id="pf4" v-model="checkpf[3]" @change="tagClick('pf4')" style="background-color: #F0F2F5">
                  3.5分以上
                </a-checkable-tag>
              </div>
              <div class="tas-dp" style="padding-left: 30px" v-if="fold=='dp'">
                <a-checkable-tag id="dp1" v-model="checkdp[0]" @change="tagClick('dp1')" style="background-color: #F0F2F5">
                  500条以上
                </a-checkable-tag>
                <a-checkable-tag id="dp2" v-model="checkdp[1]" @change="tagClick('dp2')" style="background-color: #F0F2F5">
                  200条以上
                </a-checkable-tag>
                <a-checkable-tag id="dp3" v-model="checkdp[2]" @change="tagClick('dp3')" style="background-color: #F0F2F5">
                  100条以上
                </a-checkable-tag>
                <a-checkable-tag id="dp4" v-model="checkdp[3]" @change="tagClick('dp4')" style="background-color: #F0F2F5">
                  50条以上
                </a-checkable-tag>
              </div>
              <div class="tas-zc" style="padding-left: 30px" v-if="fold=='zc'">
                <a-checkable-tag id="zc1" v-model="checkzc[0]" @change="tagClick('zc1')" style="background-color: #F0F2F5">
                  含早餐
                </a-checkable-tag>
                <a-checkable-tag id="zc2" v-model="checkzc[1]" @change="tagClick('zc2')" style="background-color: #F0F2F5">
                  单份早餐
                </a-checkable-tag>
                <a-checkable-tag id="zc3" v-model="checkzc[2]" @change="tagClick('zc3')" style="background-color: #F0F2F5">
                  双份早餐
                </a-checkable-tag>
              </div>
              <div class="tas-zf" style="padding-left: 30px" v-if="fold=='zf'">
                <a-checkable-tag id="zf1" v-model="checkzf[0]" @change="tagClick('zf1')" style="background-color: #F0F2F5">
                  在线付款
                </a-checkable-tag>
                <a-checkable-tag id="zf2" v-model="checkzf[1]" @change="tagClick('zf2')" style="background-color: #F0F2F5">
                  到店付款
                </a-checkable-tag>
                <a-checkable-tag id="zf3" v-model="checkzf[2]" @change="tagClick('zf3')" style="background-color: #F0F2F5">
                  闪住
                </a-checkable-tag>
              </div>
              <div class="tas-fx" style="padding-left: 30px" v-if="fold=='fx'">
                <a-checkable-tag id="fx1" v-model="checkfx[0]" @change="tagClick('fx1')" style="background-color: #F0F2F5">
                  大床房
                </a-checkable-tag>
                <a-checkable-tag id="fx2" v-model="checkfx[1]" @change="tagClick('fx2')" style="background-color: #F0F2F5">
                  双床房
                </a-checkable-tag>
                <a-checkable-tag id="fx3" v-model="checkfx[2]" @change="tagClick('fx3')" style="background-color: #F0F2F5">
                  多床房
                </a-checkable-tag>
                <a-checkable-tag id="fx4" v-model="checkfx[3]" @change="tagClick('fx4')" style="background-color: #F0F2F5">
                  单人床房
                </a-checkable-tag>
              </div>
              <div class="tas-ss" style="padding-left: 30px" v-if="fold=='ss'">
                <a-checkable-tag id="ss1" v-model="checkss[0]" @change="tagClick('ss1')" style="background-color: #F0F2F5">
                  免费停车
                </a-checkable-tag>
                <a-checkable-tag id="ss2" v-model="checkss[1]" @change="tagClick('ss2')" style="background-color: #F0F2F5">
                  新开业/新装修
                </a-checkable-tag>
                <a-checkable-tag id="ss3" v-model="checkss[2]" @change="tagClick('ss3')" style="background-color: #F0F2F5">
                  允许携带宠物
                </a-checkable-tag>
                <a-checkable-tag id="ss4" v-model="checkss[3]" @change="tagClick('ss4')" style="background-color: #F0F2F5">
                  停车场
                </a-checkable-tag>
                <a-checkable-tag id="ss5" v-model="checkss[4]" @change="tagClick('ss5')" style="background-color: #F0F2F5">
                  室内游泳
                </a-checkable-tag>
                <a-checkable-tag id="ss6" v-model="checkss[5]" @change="tagClick('ss6')" style="background-color: #F0F2F5">
                  接送服务
                </a-checkable-tag>
                <a-checkable-tag id="ss7" v-model="checkss[6]" @change="tagClick('ss7')" style="background-color: #F0F2F5">
                  健身房
                </a-checkable-tag>
                <a-checkable-tag id="ss8" v-model="checkss[7]" @change="tagClick('ss8')" style="background-color: #F0F2F5">
                  会议设施
                </a-checkable-tag>
              </div>
              <div class="tas-yh" style="padding-left: 30px" v-if="fold=='yh'">
                <a-checkable-tag id="yh1" v-model="checkyh[0]" @change="tagClick('yh1')" style="background-color: #F0F2F5">
                  十亿豪补
                </a-checkable-tag>
                <a-checkable-tag id="yh2" v-model="checkyh[1]" @change="tagClick('yh2')" style="background-color: #F0F2F5">
                  今夜甩卖
                </a-checkable-tag>
                <a-checkable-tag id="yh3" v-model="checkyh[2]" @change="tagClick('yh3')" style="background-color: #F0F2F5">
                  超级周末
                </a-checkable-tag>
                <a-checkable-tag id="yh4" v-model="checkyh[3]" @change="tagClick('yh4')" style="background-color: #F0F2F5">
                  门店首单
                </a-checkable-tag>
                <a-checkable-tag id="yh5" v-model="checkyh[4]" @change="tagClick('yh5')" style="background-color: #F0F2F5">
                  限时抢购
                </a-checkable-tag>
              </div>
              <div class="tas-lx" style="padding-left: 30px" v-if="fold=='lx'">
                <a-checkable-tag id="lx1" v-model="checklx[0]" @change="tagClick('lx1')" style="background-color: #F0F2F5">
                  民宿
                </a-checkable-tag>
                <a-checkable-tag id="lx2" v-model="checklx[1]" @change="tagClick('lx2')" style="background-color: #F0F2F5">
                  酒店
                </a-checkable-tag>
                <a-checkable-tag id="lx3" v-model="checklx[2]" @change="tagClick('lx3')" style="background-color: #F0F2F5">
                  青年旅舍
                </a-checkable-tag>
                <a-checkable-tag id="lx4" v-model="checklx[3]" @change="tagClick('lx4')" style="background-color: #F0F2F5">
                  别墅
                </a-checkable-tag>
                <a-checkable-tag id="lx5" v-model="checklx[4]" @change="tagClick('lx5')" style="background-color: #F0F2F5">
                  特色住宿
                </a-checkable-tag>
              </div>
              <div class="tas-zt" style="padding-left: 30px" v-if="fold=='zt'">
                <a-checkable-tag id="zt1" v-model="checkzt[0]" @change="tagClick('zt1')" style="background-color: #F0F2F5">
                  浪漫情侣
                </a-checkable-tag>
                <a-checkable-tag id="zt2" v-model="checkzt[1]" @change="tagClick('zt2')" style="background-color: #F0F2F5">
                  温泉汤池
                </a-checkable-tag>
                <a-checkable-tag id="zt3" v-model="checkzt[2]" @change="tagClick('zt3')" style="background-color: #F0F2F5">
                  电竞酒店
                </a-checkable-tag>
                <a-checkable-tag id="zt4" v-model="checkzt[3]" @change="tagClick('zt4')" style="background-color: #F0F2F5">
                  网红美宿
                </a-checkable-tag>
                <a-checkable-tag id="zt5" v-model="checkzt[4]" @change="tagClick('zt5')" style="background-color: #F0F2F5">
                  亲子酒店
                </a-checkable-tag>
              </div>
              <div class="tas-pp" style="padding-left: 30px" v-if="fold=='pp'">
                <a-checkable-tag id="pp1" v-model="checkpp[0]" @change="tagClick('pp1')" style="background-color: #F0F2F5">
                  希尔顿
                </a-checkable-tag>
                <a-checkable-tag id="pp2" v-model="checkpp[1]" @change="tagClick('pp2')" style="background-color: #F0F2F5">
                  YUNIK
                </a-checkable-tag>
                <a-checkable-tag id="pp3" v-model="checkpp[2]" @change="tagClick('pp3')" style="background-color: #F0F2F5">
                  城市名人
                </a-checkable-tag>
              </div>
            </div>
          </div>
        </a-list-item>
      </a-list>
    </div>


    <div>
      <transition
          enter-active-class="animate__animated animate__fadeIn"
          leave-active-class="animate__animated animate__fadeOut"
      >
        <div class="fixedSearch" v-show="showFixedSearch" style="padding-top: 30px;padding-bottom: 30px">
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
<!--                  <div style="width: 100%; text-align: right; margin:20px 0">-->
<!--                      <select-menu style=" margin-right: 50px"  >详细搜索</select-menu>-->
<!--                  </div>-->

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
      // SelectMenu,
      CouponActive,
      // Coupon,
    HotelCard
  },
  data(){
    return{
      fold:"none",
      exfold:"none",
      checkpf:[false,false,false,false],
      checkzc:[false,false,false],
      checkzf:[false,false,false],
      checkpp:[false,false,false],
      checkdp:[false,false,false,false],
      checkfx:[false,false,false,false],
      checkyh:[false,false,false,false,false],
      checklx:[false,false,false,false,false],
      checkzt:[false,false,false,false,false],
      checkremen:[false,false,false,false,false,false,false,false],
      checkss:[false,false,false,false,false,false,false,false],
      checksy:[false,false,false,false,false,false,false],
      checkjcdt:[false,false,false,false,false,false,false],
      checkjd:[false,false,false,false,false,false,false,false,false,false,false,false],
      checkxz:[false,false,false,false,false,false,false,false,false,false,false,false],
      checkxj:[false,false,false,false,false,false,false,false],
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

    unfold(id){
      this.fold=id;
    },
    tagClick(id){
      console.log("?????" +
          "")
      const elem=document.getElementById(id)
      console.log(elem.style.backgroundColor)
      if (elem.style.backgroundColor==='rgb(240, 242, 245)')
        elem.style.backgroundColor="rgb(51, 125, 250)"
      else
        elem.style.backgroundColor='rgb(240, 242, 245)'
      const randomName=["汉庭","儒家","桂圆","宜居"]

      const data = {
        name: randomName[Math.floor((Math.random()*4))],
        address: this.hotel_address,
        rate:[0,5],
        money:[this.money1,this.money2],
        hotelStar:[this.value_low_rate,this.value_high_rate]
      }
      this.getHotelMatch(data)
    },
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
