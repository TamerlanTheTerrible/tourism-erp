package me.timur.docs.exception


class ResourceNotFoundException : RuntimeException {
    constructor() : super() {}
    constructor(id: Long?) : super("Could not find record with id " + id!!) {}

    constructor(id: Int?) : super("Could not find record with id " + id!!) {}

    constructor(message: String) : super(message) {}
}