
<template>
  <el-container>
    <el-aside style="width: 200px; margin-top: 20px">
      <switch></switch>
      <!-- 这里的修改主要是实现按分类查询。ref 属性设置了一个引用名 -->
      <!-- <SideMenu></SideMenu> -->
      <SideMenu @indexSelected="listByCategory" ref="sideMenu"></SideMenu>
    </el-aside>
    <el-main>
      <!--<books></books>-->
      <books class="books-area" ref="booksArea"></books>
    </el-main>
  </el-container>
</template>

<script>
import SideMenu from './SideMenu'
import Books from './Books'
export default {
  name: 'AppLibrary',
  components: {
    Books,
    SideMenu
  },
  methods: {
    listByCategory () {
      var _this = this
      var cid = this.$refs.sideMenu.cid
      var url = 'categories/' + cid + '/books'
      this.$axios.get(url).then(resp => {
        if (resp && resp.status === 200) {
          _this.$refs.booksArea.books = resp.data
        }
      })
    }
  }
}
</script>

<style scoped>
.books-area {
  width: 990px;
  margin-left: auto;
  margin-right: auto;
}
</style>
