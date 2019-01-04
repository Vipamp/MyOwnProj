#=
Demo03:
- Julia version: 1.0.0
- Author: HeQingsong
- Date: 2018-10-27
- Deacription：Floating types
-
        特殊值	    名称	    描述
        Float16	    Float32	    Float64
        Inf16	    Inft32	    Inf	    正无穷	比所有的有限的浮点数都大
        -Inf16	    -Inft32	    -Inf	负无穷	比所有的有限的浮点数都小
        NaN16	    NaN32	    NaN	    不存在	不能和任意浮点数比较大小（包括它自己）
=#

#   1. create float variable, default type is Float32
x = 1.0
println("the x = ", x, ", type is ", typeof(x))

x = -.3
println("the x = ", x, ", type is ", typeof(x))

#   2. use scientific notation to expression float variable, you can use 'e' or 'f' instead
x = 2.345e-5
println("the x = ", x, ", type is ", typeof(x))

x = 2.345f-5
println("the x = ", x, ", type is ", typeof(x))

#   3. infinity expresion
x = 1 / 0
println("the x = ", x, ", type is ", typeof(x))
