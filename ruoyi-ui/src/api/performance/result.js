import request from '@/utils/request'

// 查询绩效结果列表
export function listResult(query) {
  return request({
    url: '/performance/result/list',
    method: 'get',
    params: query
  })
}
