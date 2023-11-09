test = int(input())
for _ in range(test):
    n = int(input())
    if n == 0:
        print('0')
        continue
    dict = {}
    for _ in range(n):
        clothes_name, clothes_type = map(str, input().split())
        if clothes_type in dict.keys():
            dict[clothes_type] += 1
        else:
            dict[clothes_type] = 1
    ans = 1
    for clothes_type  in dict.keys():
        dict[clothes_type] += 1
        ans *= dict[clothes_type]
        
    print(ans - 1)