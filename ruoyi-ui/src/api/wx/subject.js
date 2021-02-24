import request from '@/utils/request'

// 查询科目分类列表
export function listSubject(query) {
  return request({
    url: '/wx/subject/list',
    method: 'get',
    params: query
  })
}

// 查询科目分类详细
export function getSubject(id) {
  return request({
    url: '/wx/subject/' + id,
    method: 'get'
  })
}

// 新增科目分类
export function addSubject(data) {
  return request({
    url: '/wx/subject',
    method: 'post',
    data: data
  })
}

// 修改科目分类
export function updateSubject(data) {
  return request({
    url: '/wx/subject',
    method: 'put',
    data: data
  })
}

// 删除科目分类
export function delSubject(id) {
  return request({
    url: '/wx/subject/' + id,
    method: 'delete'
  })
}

// 导出科目分类
export function exportSubject(query) {
  return request({
    url: '/wx/subject/export',
    method: 'get',
    params: query
  })
}

// 获取树菜单
export function getTreelist() {
  return request({
    url: '/wx/subject/getTreelist',
    method: 'get'
  })
}

// 获取科目全称
export function getSubjectName() {
  return request({
    url: '/wx/subject/getSubjectName',
    method: 'get'
  })
}