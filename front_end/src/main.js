import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Antd from 'ant-design-vue'
import 'ant-design-vue/dist/antd.css'
import store from './store'
import VueAMap from 'vue-amap'

import vuetify from '@/plugins/vuetify' // path to vuetify export

import '@/permission'
Vue.config.productionTip = false
const options = {
  namespace: 'pro__',
  name: 'ls',
  storage: 'local'
}
Vue.use(Antd)
Vue.use(VueAMap);

VueAMap.initAMapApiLoader({
  key: 'ae0b3b501631fe61ed7be6354a640cc1',
  plugin: ['AMap.Autocomplete','AMap.Geocoder', 'AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.AMapManager','AMap.Geolocation'],
  v: '1.4.4',
  uiVersion: '1.0.11'
});

Vue.directive('title', {
  inserted: function (el, binding) {
    document.title = el.dataset.title
  }
})
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
