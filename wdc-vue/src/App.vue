<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <router-view/>
    <!-- <el-button>默认按钮</el-button>
    <el-button type="primary">主要按钮</el-button>
    <el-button type="text">文字按钮</el-button>
    <el-input-number v-model="num1" @change="handleChange" :min="1" :max="10"></el-input-number>
    <br />
    <el-input placeholder="elinput输入框">a</el-input> -->
  </div>
</template>

<script>
export default {
  name: 'App'
  // data () {
  //   return {
  //     num1: 1
  //   }
  // },
  // methods: {
  //   handleChange (value) {
  //     console.log(value)
  //   }
  // }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */ /* 这个会让网页顶部有60px的空白高度 */
}
</style>
