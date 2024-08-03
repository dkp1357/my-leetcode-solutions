int trailingZeroes(int n) {
    int result = 0;
    int i = 5;
    while(n/i != 0)
    {
        result += (n/i);
        i *= 5;
    }
    return result;
}

/*

long result = 0;
    long n1 = (long)n;
    long i = 5;
    while(n1/i != 0)
    {
        result += (n1/i);
        i *= 5;
    }
    return (int)result;
    
*/