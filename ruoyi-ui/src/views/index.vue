<template>
  <div>
    <el-row ::gutter="15">
      <el-col :span="16" :offset="2">
        <div class="grid-content bg-purple" justify="center">
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>通知公告</span>
            </div>
             <div class="notice_list">  
               <ul>
                  <li v-for="(notice,index) in noticeList" :key="index">
                    <a class="a_style" @click="getInfo(notice)">{{notice.noticeTitle}}</a>
                    <span class="create_time"> {{ notice.createTime }}</span>
                    <p/>
                  </li>
              </ul>
             </div>
          </el-card>
        </div>
      </el-col>
    </el-row>
  
  <el-dialog title="通知详细界面" :visible.sync="open" width="700px">
      <el-form ref="form" :model="form" label-width="100px" size="mini">
        <el-row>
          <el-col :span="12">
            <el-form-item label="通知标题：">{{ form.noticeTitle }}</el-form-item>
            <el-form-item label="状态：">
              <div v-if="form.status == 0">正常</div>
              <div v-else-if="form.status == 1">关闭</div>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态：">
              <div v-if="form.noticeType == 1">通知</div>
              <div v-else-if="form.noticeType == 2">公告</div>
            </el-form-item>
            <el-form-item label="创建时间：">   
               {{ form.createTime }}
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="通知内容：" > <b v-html = 'form.noticeContent'></b> </el-form-item>
          </el-col>
        </el-row>
        </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="open = false">关 闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listNotice, getNotice } from "@/api/system/notice";
import Editor from "@/components/Editor";
export default {
  components: {
    Editor
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 公告表格数据
      noticeList: [],
      date:new Date(),
      open: false,
      form:{},
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        noticeTitle: undefined,
        createBy: undefined,
        status: "0"
      },
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_notice_status").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("sys_notice_type").then(response => {
      this.typeOptions = response.data;
    });
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true;
      listNotice(this.queryParams).then(response => {
        this.noticeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 公告状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    // 公告状态字典翻译
    typeFormat(row, column) {
      return this.selectDictLabel(this.typeOptions, row.noticeType);
    },
    getInfo(notice){
      this.open = true;
      this.form = notice;
    }
  }
};
</script>

<style lang="scss" scoped>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 100%; 
  margin: 0 auto;
}

.create_time{
  float:right
}

</style>
