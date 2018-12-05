
def square = new int[1000][1000];

new File('src/main/resources/input').each {
    def parts = it.split(':');
    def rect = new Rectangle();
    def leftTop = parts[0].split(',');
    rect.left = Integer.parseInt(leftTop[0].split('@')[1].trim())
    rect.top = Integer.parseInt(leftTop[1].trim())
    def widthLength = parts[1].split('x')
    rect.width = Integer.parseInt(widthLength[0].trim())
    rect.height = Integer.parseInt(widthLength[1].trim())

    for (int x = rect.left; x < rect.left + rect.width; x++) {
        for (int y = rect.top; y < rect.top + rect.height; y++) {
            square[x][y]++;
        }
    }
}

def count = 0;
for (int x = 0; x < 1000; x++) {
    for (int y = 0; y < 1000; y++) {
        if (square[x][y] > 1)
            count++;
    }
}
printf("Result is $count")

class Rectangle {
    int top;
    int left;
    int width;
    int height;
}