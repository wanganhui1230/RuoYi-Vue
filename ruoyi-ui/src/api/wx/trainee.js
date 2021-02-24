import request from '@/utils/request'

// 查询学员列表
export function listTrainee(query) {
  return request({
    url: '/wx/trainee/list',
    method: 'get',
    params: query
  })
}

// 查询学员详细
export function getTrainee(id) {
  return request({
    url: '/wx/trainee/' + id,
    method: 'get'
  })
}

// 新增学员
export function addTrainee(data) {
  return request({
    url: '/wx/trainee',
    method: 'post',
    data: data
  })
}

// 修改学员
export function updateTrainee(data) {
  return request({
    url: '/wx/trainee',
    method: 'put',
    data: data
  })
}

// 删除学员
export function delTrainee(id) {
  return request({
    url: '/wx/trainee/' + id,
    method: 'delete'
  })
}

// 导出学员
export function exportTrainee(query) {
  return request({
    url: '/wx/trainee/export',
    method: 'get',
    params: query
  })
}