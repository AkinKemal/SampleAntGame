public class AntGame {

    DoublyLinkedListsOperations map = new DoublyLinkedListsOperations();
    ReaderFile readerFile = new ReaderFile();
    WriterFile writerFile = new WriterFile();

    public void createMap() {

        readerFile.readerFile();

        int height = 0, weight = 0, antHeight = 1, antWeight = 1;
        int value;//csv dosyasından gelen hareket miktarını tutmak için

        for (int i = 0; i < readerFile.moveOperation.size(); i++) {
            value = Integer.parseInt(readerFile.moveNumber.get(i));

            switch (readerFile.moveOperation.get(i)) {
                case "move up":
                    if ((value + antHeight) == height) {
                        antHeight = height;
                    } else if ((value + antHeight) > height) {
                        //antHeight = height - antHeight;
                        height = (value + antHeight);
                        antHeight = height;
                    } else {
                        antHeight += value;
                    }
                    break;
                case "move down":
                    if ((value + (height - antHeight + 1)) == height) {
                        antHeight = 1;
                    } else if ((value + (height - antHeight + 1)) > height) {
                        height = (value + (height - antHeight) + 1);
                        antHeight = 1;
                    } else {
                        antHeight -= value;
                    }
                    break;
                case "move right":
                    if ((value + antWeight) == weight) {
                        antWeight = weight;
                    } else if ((value + antWeight) > weight) {
                        weight = (value + antWeight);
                        antWeight = weight;
                    } else {
                        antWeight += value;
                    }
                    break;
                case "move left":
                    if ((value + (weight - antWeight) + 1) == weight) {
                        antWeight = 1;
                    } else if ((value + (weight - antWeight) + 1) > weight) {
                        weight = (value + (weight - antWeight) + 1);
                        antWeight = 1;
                    } else {
                        antWeight -= value;
                    }
                    break;
                default:
                    System.out.println("Warning...");
                    break;
            }
        }

        for (int i = 0; i < height * weight; i++) {
            if ((((height - (antHeight)) * weight) + antWeight) == (i + 1)) {
                map.add("*");
            } else {
                map.add("X");
            }
        }

        writerFile.writerFile(map.print(height, weight));
    }
}