#include <stdio.h>

int main()
{
	int N;
	int count = 0;
	scanf("%d", &N);

	while (N > 0)
	{
		if (N % 5 == 0)
		{
			N -= 5;
			count++;
		}
		else if (N % 3 == 0)
		{
			N -= 3;
			count++;
		}
		else if (N > 5)
		{
			N -= 5;
			count++;
		}
		else
        {
			count = -1;
            break;
        }
	}

	printf("%d", count);
	return 0;

}