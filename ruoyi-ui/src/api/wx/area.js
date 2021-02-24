import request from '@/utils/request'

// 查询区域列表
export function listArea(query) {
  return request({
    url: '/wx/area/list',
    method: 'get',
    params: query
  })
}

// 查询区域详细
export function getArea(id) {
  return request({
    url: '/wx/area/' + id,
    method: 'get'
  })
}

// 新增区域
export function addArea(data) {
  return request({
    url: '/wx/area',
    method: 'post',
    data: data
  })
}

// 修改区域
export function updateArea(data) {
  return request({
    url: '/wx/area',
    method: 'put',
    data: data
  })
}

// 删除区域
export function delArea(id) {
  return request({
    url: '/wx/area/' + id,
    method: 'delete'
  })
}

// 导出区域
export function exportArea(query) {
  return request({
    url: '/wx/area/export',
    method: 'get',
    params: query
  })
}