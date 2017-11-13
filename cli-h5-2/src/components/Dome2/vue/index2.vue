<style lang="less" scoped>
.index2{
  color: #ccc
}

</style>
<template>
  <section>
    <span class="index2">{{5555|sum}}</span>
  </section>
</template>
<script>
  import {gtFilters} from '@/filters/index.js'
  export default {
    data() {
      return {
        date: new Date()
      }
    },
    mounted() {
      console.log(new Date())
    },
    filters: gtFilters
  }

</script>
