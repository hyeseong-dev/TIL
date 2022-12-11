import re 

def find_pattern(pattern, string):
    match = re.findall(pattern, string)
    if not match:
        print("일치하는 데이터가 없습니다.")
        return 
    return("일치하는 데이터를 찾았습니다: {0}".format(match))

if __name__ == "__main__":
    result = find_pattern("o", "Hello World")
    print(result)