<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入老师名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区域" prop="area">
        <el-select v-model="queryParams.area" placeholder="请选择区域" clearable size="small">
          <el-option 
          :key="area.uid" v-for="area in areaList" 
          :label="area.name" 
          :value="area.id" />
        </el-select>
      </el-form-item>
      <el-form-item label="院校" prop="colleges">
        <el-input
          v-model="queryParams.colleges"
          placeholder="请输入院校"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable size="small">
          <el-option label="男" value="男" />
          <el-option label="女" value="女" />
        </el-select>
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信号" prop="wechat">
        <el-input
          v-model="queryParams.wechat"
          placeholder="请输入微信号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="qq号" prop="qq">
        <el-input
          v-model="queryParams.qq"
          placeholder="请输入qq号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证" prop="cardH">
        <el-input
          v-model="queryParams.cardH"
          placeholder="请输入身份证号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择认证状态" clearable size="small">
          <el-option label="已认证" value="已认证" />
          <el-option label="未认证" value="未认证" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['wx:teacher:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['wx:teacher:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['wx:teacher:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wx:teacher:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="teacherList" style="width: 100%" max-height="1200" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="numberId" />
      <el-table-column label="名称" align="center" prop="name" />
      <el-table-column label="老师等级" align="center" prop="spare3" />
      <el-table-column label="科目" align="center" prop="subjectName" />
      <el-table-column label="区域" align="center" prop="areaName" />
      <el-table-column label="高考分数" align="center" prop="fraction" />
      <el-table-column label="院校" align="center" prop="colleges" />
      <el-table-column label="最近登录时间" align="center" prop="loginTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.loginTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="视频">
        <template slot-scope="scope">
          <el-button type="primary" @click="playVideo(scope.row.spare1)" ref="btn" size="mini"> 
          视频
          </el-button>
        </template>
      </el-table-column>
      <el-table-column label="头像">
          <template slot-scope="scope">
						<el-popover placement="top-start" trigger="click">
							<a :href="scope.row.image" target="_blank" title="查看最大化图片"><img :src="scope.row.image" style="width: 600px;height: 600px" /></a>
							<img slot="reference" :src="scope.row.image" style="width: 50px;height: 50px; cursor:pointer" />
						</el-popover>
					</template>
      </el-table-column>
      <el-table-column label="性别" align="center" prop="sex" />
      <el-table-column label="目前身份" align="center" prop="identity" />
      <el-table-column label="手机号" align="center" prop="phone" />
      <el-table-column label="微信号" align="center" prop="wechat" />
      <el-table-column label="qq号" align="center" prop="qq" />
      <el-table-column label="身份证正">
      　　<template slot-scope="scope">
						<el-popover placement="top-start" trigger="click">
							<a :href="scope.row.cardZ" target="_blank" title="查看最大化图片"><img :src="scope.row.cardZ" style="width: 600px;height: 600px" /></a>
							<img slot="reference" :src="scope.row.cardZ" style="width: 50px;height: 50px; cursor:pointer" />
						</el-popover>
					</template>
      </el-table-column>
      <el-table-column label="身份证反">
      　　<template slot-scope="scope">
						<el-popover placement="top-start" trigger="click">
							<a :href="scope.row.cardF" target="_blank" title="查看最大化图片"><img :src="scope.row.cardF" style="width: 600px;height: 600px" /></a>
							<img slot="reference" :src="scope.row.cardF" style="width: 50px;height: 50px; cursor:pointer" />
						</el-popover>
					</template>
      </el-table-column>
      <el-table-column label="毕业证">
          <template slot-scope="scope">
						<el-popover placement="top-start" trigger="click">
							<a :href="scope.row.studentCard" target="_blank" title="查看最大化图片"><img :src="scope.row.studentCard" style="width: 600px;height: 600px" /></a>
							<img slot="reference" :src="scope.row.studentCard" style="width: 50px;height: 50px; cursor:pointer" />
						</el-popover>
					</template>
      </el-table-column>
      <el-table-column label="身份证号" align="center" prop="cardH" />
      <el-table-column label="认证状态" align="center" prop="status" />
      <el-table-column label="热度" align="center" prop="heat" />
      <el-table-column label="操作"  fixed="right" width="200">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wx:teacher:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wx:teacher:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
  <el-dialog title :visible.sync="dialogPlay" width="30%" @close="closeDialog">
         <video :src="videoUrl" controls autoplay class="video" 
         width="100%"></video>
  </el-dialog>

    <!-- 添加或修改老师对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="老师名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入老师名称" />
        </el-form-item>
        <el-form-item label="科目" prop="subject">
            <treeselect :disable-branch-nodes="true" v-model="form.subject" :options="getTreelist" :show-count="true" placeholder="请选择科目"/>
        </el-form-item>
        <el-form-item label="区域" prop="area">
          <el-select v-model="form.area" placeholder="请选择区域">
              <el-option 
              :key="area.uid" v-for="area in areaList"
              :label="area.name" 
              :value="area.id" />
          </el-select>
        </el-form-item>
        <el-form-item label="高考分数" prop="fraction">
          <el-input v-model="form.fraction" placeholder="请输入高考分数" />
        </el-form-item>
        <el-form-item label="院校" prop="colleges">
          <el-input v-model="form.colleges" placeholder="请输入院校" />
        </el-form-item>
        <!-- <el-form-item label="最近登录时间" prop="loginTime">
          <el-date-picker clearable size="small"
            v-model="form.loginTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择最近登录时间">
          </el-date-picker>
        </el-form-item> -->
        <el-form-item label="头像">
          <imageUpload v-model="form.image"/>
        </el-form-item>
        <el-form-item label="视频">
          <fileUpload v-model="form.spare1"/>
        </el-form-item>
        <!-- <el-form-item label="编号id" prop="numberId">
          <el-input v-model="form.numberId" placeholder="请输入编号id" />
        </el-form-item> -->
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option  value="男" label="男"/>
            <el-option  value="女" label="女"/>
          </el-select>
        </el-form-item>
        <el-form-item label="目前身份" prop="identity">
          <el-input v-model="form.identity" placeholder="请输入目前身份" />
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="微信号" prop="wechat">
          <el-input v-model="form.wechat" placeholder="请输入微信号" />
        </el-form-item>
        <el-form-item label="qq号" prop="qq">
          <el-input v-model="form.qq" placeholder="请输入qq号" />
        </el-form-item>
        <el-form-item label="身份证正">
          <imageUpload v-model="form.cardZ"/>
        </el-form-item>
        <el-form-item label="身份证反">
          <imageUpload v-model="form.cardF"/>
        </el-form-item>
        <el-form-item label="学生证和毕业证">
          <imageUpload v-model="form.studentCard"/>
        </el-form-item>
        <el-form-item label="身份证号" prop="cardH">
          <el-input v-model="form.cardH" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="认证状态">
          <el-radio-group v-model="form.status">
            <el-radio label="已认证">已认证</el-radio>
            <el-radio label="未认证">未认证</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="教师等级">
          <el-radio-group v-model="form.spare3">
            <el-radio label="S">S</el-radio>
            <el-radio label="A">A</el-radio>
            <el-radio label="B">B</el-radio>
            <el-radio label="C">C</el-radio>
            <el-radio label="D">D</el-radio>
            <el-radio label="E">E</el-radio>
          </el-radio-group>
        </el-form-item>
        <!-- <el-form-item label="热度" prop="heat">
          <el-input v-model="form.heat" placeholder="请输入热度" />
        </el-form-item> -->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTeacher, getTeacher, delTeacher, addTeacher, updateTeacher, exportTeacher } from "@/api/wx/teacher";
import { listArea} from "@/api/wx/area";
import { getTreelist,getSubjectName} from "@/api/wx/subject";
import ImageUpload from '@/components/ImageUpload';
import Treeselect from '@riophae/vue-treeselect'
import FileUpload from '@/components/FileUpload';
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
export default {
  name: "Teacher",
  components: {
    ImageUpload,Treeselect,FileUpload,
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 老师表格数据
      teacherList: [],
      // 区域表格数据
      areaList: [],
      // 树菜单
      getTreelist: [],
      //获取科目全称
      getSubjectName: [],
      // 弹出层标题
      title: "",
      videoUrl:"",
      // 是否显示弹出层
      dialogPlay: false,
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        subject: null,
        area: null,
        colleges: null,
        sex: null,
        phone: null,
        wechat: null,
        qq: null,
        cardH: null,
        status: null,
      },
      // 通用
      queryParamsTy: {
        pageNum: 1,
        pageSize: 1000,
        name: null,
        srot: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },

  methods: {
    
    // 视频播放
    playVideo(row) {
      this.dialogPlay = true;
      this.videoUrl = row;
    },

    /** 查询老师列表 */
    getList() {
      this.loading = true;
      getTreelist(this.queryParamsTy).then(response => {
        this.getTreelist = response.data;
      });
      getSubjectName(this.queryParamsTy).then(response => {
            this.getSubjectName = response.data; 
      });
      listArea(this.queryParamsTy).then(response => {
        this.areaList = response.rows;
            listTeacher(this.queryParams).then(response => {
              this.teacherList = response.rows;
              this.total = response.total;
              this.loading = false;
              this.teacherList.map(element => {
                this.areaList.filter(o => o.id == element.area).forEach(o1 => {
                    element.areaName = o1.name
                });
                this.getSubjectName.filter(o => o.id == element.subject).forEach(o1 => {
                    element.subjectName = o1.name
                });
                return element;
              });
        });
      });
    },
    closeDialog() {
    this.videoUrl = ""; //清空数据 关闭视频播放
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        subject: null,
        area: null,
        fraction: null,
        colleges: null,
        loginTime: null,
        image: null,
        numberId: null,
        openId: null,
        sex: null,
        identity: null,
        phone: null,
        wechat: null,
        qq: null,
        cardZ: null,
        cardF: null,
        studentCard: null,
        cardH: null,
        status: null,
        heat: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        spare1: null,
        spare2: null,
        spare3: null,
        spare4: null,
        spare5: null,
        spare6: null,
        spare7: null,
        spare8: null,
        spare9: null,
        spare10: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加老师";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTeacher(id).then(response => {
        console.log(response.data+"11111")
        alert("2222")
        this.form = response.data;
        this.open = true;
        this.title = "修改老师";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTeacher(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTeacher(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除老师编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTeacher(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有老师数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportTeacher(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
