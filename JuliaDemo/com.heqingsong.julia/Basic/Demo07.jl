#=
Demo07:
- Julia version: 1.0.0
- Author: HeQingsong
- Date: 2018-10-27
- Descroption：String
=#

#   1.  char
x = 'x'
println("the type of x is ",typeof(x))

#   2.  String
s = "Hello Julia!"
println(s)

longstr = """
hello world!
I am HeQingsong,
I am studing Julia now!
"""
println(longstr)


#   3.  get char or substring from string, the start index is 1, not 0,if index out of bounds, throw BoundsError
println("s1 = ",s[3])           # get forth char
println("the end char of string is ",s[end])
println("s2 = ",s[3:6])         # get subString from s, index from 3 to 6, include start index and exclude end index

#   4.  traverse string by char
for c in s
    println(c)
end

#   5.  string append
name = "HeQingsong"
age = "25"
des = string("hello, I am ",name,", I am ",age ," years old!")
println(des)
println("hello, I am $name, I am $age years old!")
println("1 + 2 = $(1 + 2)")

#   6.  char or substring search
# println("the index of char 'I' is ",search(des,'I'))

#   7.  repeat string to a longer string
println(repeat("hi,", 10))

#   8.  get length of string
println("the length of string 'des' is ",length(des))
