package deploy.runner

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'POST'
        url value(consumer(regex('/run/[0-9]{1,9}')))
        body([
               "host": $(regex('.*')),
               port : $(regex('[0-9]{3,6}'))
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body(1)
    }
}
