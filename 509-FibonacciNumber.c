// 509

int fib(int n){

    if (n <= 1)
        return n;

    int a = 0; // 0 th element
    int b = 1; // 1 st element
    int c;
    for (int i = 2; i <= n; i++)
    {
        c = a+b;
        a = b;
        b = c;
    }
    return c;
}