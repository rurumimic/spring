import interceptor from 'rest/interceptor'

export default interceptor({
    request: function(request) {
        if (request.path.indexOf('{') === -1) {
            return request
        } else {
            request.path = request.path.split('{')[0]
            return request
        }
    }
})
