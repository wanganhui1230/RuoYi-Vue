import request from '@/utils/request'

// 查询老师列表
export function listTeacher(query) {
  return request({
    url: '/wx/teacher/list',
    method: 'get',
    params: query
  })
}

// 查询老师详细
export function getTeacher(id) {
  return request({
    url: '/wx/teacher/' + id,
    method: 'get'
  })
}

// 新增老师
export function addTeacher(data) {
  return request({
    url: '/wx/teacher',
    method: 'post',
    data: data
  })
}

// 修改老师
export function updateTeacher(data) {
  return request({
    url: '/wx/teacher',
    method: 'put',
    data: data
  })
}

// 删除老师
export function delTeacher(id) {
  return request({
    url: '/wx/teacher/' + id,
    method: 'delete'
  })
}

// 导出老师
export function exportTeacher(query) {
  return request({
    url: '/wx/teacher/export',
    method: 'get',
    params: query
  })
}