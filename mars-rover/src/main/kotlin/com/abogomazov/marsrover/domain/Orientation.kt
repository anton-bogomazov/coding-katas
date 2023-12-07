package com.abogomazov.marsrover.domain

enum class Orientation(
    val axis: Axis,
    val delta: Int,
) {
    N(Axis.Y, 1) {
        override fun onLeft() = W
        override fun onRight() = E
    },
    S(Axis.Y, -1) {
        override fun onLeft() = E
        override fun onRight() = W
    },
    E(Axis.X, 1) {
        override fun onLeft() = N
        override fun onRight() = S
    },
    W(Axis.X, -1) {
        override fun onLeft() = S
        override fun onRight() = N
    };

    abstract fun onLeft(): Orientation
    abstract fun onRight(): Orientation
}
