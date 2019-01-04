#=
Demo02:
- Julia version: 1.0.0
- Author: HeQingsong
- Date: 2018-10-27
- Decription：Integer Type
=#

#   1. create Integer tupe variable
x = 10
println(x)

#   2. get the variable type by using function 'typeof',integer default type depend on machine,
#      if machine is 32bit, the type is Int32,else the type is Int64
println("the type of variable is ",typeof(x))

#   3. number system
println("the type of 1 is",typeof(1))
println("the type of 0b01 is ",typeof(0b01))
println("the type of 011 is ",typeof(011))
println("the type of 0xfe is ",typeof(0xfe))
println("the type of 0xfedf is ",typeof(0xfedf))
println("the type of 0xfabedf is ",typeof(0xfabedf))

#   4. get the max value and min value of the variable type
println("the min value of Int32 type is ",typemin(Int32))
println("the max value of Int32 type is ",typemax(Int32))
println("the min value of UInt32 type is ",typemin(UInt32))
println("the max value of UInt32 type is ",typemax(UInt32))

