
import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
// 导入编写的组件
import AppIndex from '../components/home/Appindex'
import Login from '../components/Login'
import Home from '../components/home'
import LibraryIndex from '../components/library/LibraryIndex'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [{
    path: '/home',
    name: 'Home',
    component: Home,
    // home页面并不需要被访问
    redirect: '/index',
    children: [{
      path: '/index',
      name: 'AppIndex',
      component: AppIndex,
      meta: {
        requireAuth: true
      }
    },
    {
      path: '/library',
      name: 'Library',
      component: LibraryIndex,
      meta: {
        requireAuth: true
      }
    }]
  },
  {
    path: '/',
    name: 'HelloWorld',
    component: HelloWorld
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  // {
  //   path: '/index',
  //   name: 'AppIndex',
  //   component: AppIndex,
  //   meta: {
  //     requireAuth: true
  //   }
  // },
  {
    path: '/',
    name: 'index',
    redirect: '/index',
    component: AppIndex,
    meta: {
      requireAuth: true
    }
  }]
})