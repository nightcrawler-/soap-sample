package com.cafrecode.soapsample.api.response.core

// Util class to handle should-be-array responses wrapped in objects
open class ResponseWrapper<T> {
    var code: String? = null
    var data: T? = null
    var message: String? = null
    var token: String? = null
}
