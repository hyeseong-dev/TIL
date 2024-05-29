input_num = int(input())
for i in range(input_num):
    num,s = input().split(' ') 
    string = ""
    for i in s : 
        string += int(num)*i
    print(string)
