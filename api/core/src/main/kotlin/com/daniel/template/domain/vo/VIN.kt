package com.daniel.template.domain.vo

data class VIN(val value: String) {
    init {
        require(value.length <= 18)
    }
}