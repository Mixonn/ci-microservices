package deployrunner

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url value(consumer(regex('/run/.{1,9}')))
        body([
               "host": $(regex('[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}')),
               port : $(regex('[0-9]{3,6}'))
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status ACCEPTED()
        body($(regex(".{1,20}")))
    }
}
