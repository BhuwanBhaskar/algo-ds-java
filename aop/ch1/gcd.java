package aop.ch1;

public class gcd {
  static int gcd_e(int m, int n) {
    int r = m % n;
    if (r == 0) {
      return n;
    }

    m = n;
    n = r;
    return gcd.gcd_e(m, n);
  }

  static int gcd_f(int m, int n) {
    m = m % n;
    if (m == 0) {
      return n;
    }

    n = n % m;
    if (n == 0) {
      return m;
    }

    return gcd.gcd_f(m, n);
  }

  static int count_e1(int m, int n, int counter) {
    int r = m % n;
    counter += 1;

    if (r == 0) {
      return counter;
    }

    m = n;
    n = r;
    return gcd.count_e1(m, n, counter);
  }

  /**
   * Get average
   * @param n
   * @return
   */
  static float avg_e1(int n) {
    float avg = 0;
    int len = 10000;
    for(int i = 1; i < len; i += 1) {
      avg += gcd.count_e1(i, n, 0);
    }

    return avg / len;
  }

  public static void main(String[] args) {
    int m = 2166;
    int n = 6099;

    System.out.println(gcd.gcd_f(m, n));
    System.out.println(gcd.gcd_e(m, n));
    System.out.println(gcd.avg_e1(5));

  }
}