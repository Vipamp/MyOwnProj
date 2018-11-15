#=
Demo01:
- Julia version: 1.0.0
- Author: HeQingsong
- Date: 2018-10-28
=#

#   1.  standard function, key word 'return' can be omit
function add(x, y)
    return x + y
end

#   2.  simple function
add2(x, y) =x + y
println(add(1,3))
println(add2(1,3))

#   3.  function varoable
add3 = add2
println(add3(1,2))

#   4.  use apply function to call function and send parameters
# println(apply(add3,1,3))

#   5.  function calculator symbol
println((1 + 2 + 3))
println(+(1,2,3))
f = +
println(f(1,2,3,4,5))

