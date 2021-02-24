import request from '@/utils/request'

// 查询科目详情列表
export function listDetails(query) {
  return request({
    url: '/wx/details/list',
    method: 'get',
    params: query
  })
}

// 查询科目详情详细
export function getDetails(id) {
  return request({
    url: '/wx/details/' + id,
    method: 'get'
  })
}

// 新增科目详情
export function addDetails(data) {
  return request({
    url: '/wx/details',
    method: 'post',
    data: data
  })
}

// 修改科目详情
export function updateDetails(data) {
  return request({
    url: '/wx/details',
    method: 'put',
    data: data
  })
}

// 删除科目详情
export function delDetails(id) {
  return request({
    url: '/wx/details/' + id,
    method: 'delete'
  })
}

// 导出科目详情
export function exportDetails(query) {
  return request({
    url: '/wx/details/export',
    method: 'get',
    params: query
  })
}