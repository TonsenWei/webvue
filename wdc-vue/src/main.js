// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'
// 设置反向代理， 前端请求默认发送到http://localhost:8443/api
var axios = require('axios')
// axios.defaults.baseURL = 'http://desktop-dn3inld:8443/api'
// axios.defaults.baseURL = 'http://hzh4668c:8443/api'
// axios.defaults.baseURL = 'http://0.0.0.0:8089/api'
// axios.defaults.baseURL = 'http://hzh4668c:8089/demo-0.0.1-SNAPSHOT/api'
axios.defaults.baseURL = 'http://39.102.93.206:8089/demo-0.0.1-SNAPSHOT/api'
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios
Vue.config.productionTip = false
Vue.use(ElementUI)

/**
 * 首先判断访问的路径是否需要登录，
 * 如果需要，判断 store 里有没有存储 user 的信息，
 * 如果存在，则放行，否则跳转到登录页面，
 * 并存储访问的页面路径（以便在登录后跳转到访问页）。
 */
router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  // 增加store用于路由拦截
  store,
  components: { App },
  template: '<App/>'
})
