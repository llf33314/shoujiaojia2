<template>
  <section>
    admin
  </section>
</template>
<script>
  export default {
    name: 'index',
    data() {
      return {
        dialogVisible: false
      };
    },
    methods: {
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    }
  }

</script>
<style>


</style>
