<template>
  <div>
    <el-cascader :options="options" v-model="selectedOptions" @change="changeRegionOptions" placeholder="请选择省市区">
    </el-cascader>
  </div>
</template>

<script>
  import {
    Region
  } from '../../../../static/js/lib/region.js'
  export default {
    data() {
      return {
        options: Region
      }
    },
    props: {
      selectedOptions: {
        type: Array,
        default: []
      }
    },
    methods: {
      changeRegionOptions(evt) {
        const r0 = this.selectedOptions[0]
        const r1 = this.selectedOptions[1]
        const r2 = this.selectedOptions[2]
        var mm = []
        Region.forEach(function (item) {
          if (item.value == r0) {
            mm.push(item.label)
            if (item.children) {
              item.children.forEach(function (child) {
                if (child.value == r1) {
                  mm.push(child.label)
                }
                if (child.children) {
                  child.children.forEach(function (child2) {
                    if (child2.value == r2) {
                      mm.push(child2.label)
                    }
                  })
                }
              })
            }
          }
        });
        this.$emit('change', {
          value: evt,
          name: mm
        })
      }
    }
  }

</script>
