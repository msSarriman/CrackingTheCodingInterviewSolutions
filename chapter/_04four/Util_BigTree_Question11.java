/*
MIT License

Copyright (c) 2019 Emmanouil Sarris

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package chapter._04four;

public class Util_BigTree_Question11 {
    Util_BinTreeNode<Integer> bigRoot;

    Util_BigTree_Question11() {
        /* Binary tree to be created:
         *                              28
         *             14                                70
         *      7              21                50              90
         *  5      10      17      25        40      55      80      100
         *1   6   9  11  16  18  24  26    38  42  52  58  71  85  95   105
         *  */
        Util_BinTreeNode<Integer> node28 = new Util_BinTreeNode<>(28);

        Util_BinTreeNode<Integer> node14 = new Util_BinTreeNode<>(14, node28);
        Util_BinTreeNode<Integer> node70 = new Util_BinTreeNode<>(70, node28);

        Util_BinTreeNode<Integer> node7 = new Util_BinTreeNode<>(7, node14);
        Util_BinTreeNode<Integer> node21 = new Util_BinTreeNode<>(21, node14);
        Util_BinTreeNode<Integer> node50 = new Util_BinTreeNode<>(50, node70);
        Util_BinTreeNode<Integer> node90 = new Util_BinTreeNode<>(90, node70);

        Util_BinTreeNode<Integer> node5 = new Util_BinTreeNode<>(5, node7);
        Util_BinTreeNode<Integer> node10 = new Util_BinTreeNode<>(10, node7);
        Util_BinTreeNode<Integer> node17 = new Util_BinTreeNode<>(17, node21);
        Util_BinTreeNode<Integer> node25 = new Util_BinTreeNode<>(25, node21);
        Util_BinTreeNode<Integer> node40 = new Util_BinTreeNode<>(40, node50);
        Util_BinTreeNode<Integer> node55 = new Util_BinTreeNode<>(55, node50);
        Util_BinTreeNode<Integer> node80 = new Util_BinTreeNode<>(80, node90);
        Util_BinTreeNode<Integer> node100 = new Util_BinTreeNode<>(100, node90);

        Util_BinTreeNode<Integer> node1 = new Util_BinTreeNode<>(1, node5);
        Util_BinTreeNode<Integer> node6 = new Util_BinTreeNode<>(6, node5);
        Util_BinTreeNode<Integer> node9 = new Util_BinTreeNode<>(9, node10);
        Util_BinTreeNode<Integer> node11 = new Util_BinTreeNode<>(11, node10);
        Util_BinTreeNode<Integer> node16 = new Util_BinTreeNode<>(16, node17);
        Util_BinTreeNode<Integer> node18 = new Util_BinTreeNode<>(18, node17);
        Util_BinTreeNode<Integer> node24 = new Util_BinTreeNode<>(24, node25);
        Util_BinTreeNode<Integer> node26 = new Util_BinTreeNode<>(26, node25);
        Util_BinTreeNode<Integer> node38 = new Util_BinTreeNode<>(38, node40);
        Util_BinTreeNode<Integer> node42 = new Util_BinTreeNode<>(42, node40);
        Util_BinTreeNode<Integer> node52 = new Util_BinTreeNode<>(52, node55);
        Util_BinTreeNode<Integer> node58 = new Util_BinTreeNode<>(58, node55);
        Util_BinTreeNode<Integer> node71 = new Util_BinTreeNode<>(71, node80);
        Util_BinTreeNode<Integer> node85 = new Util_BinTreeNode<>(85, node80);
        Util_BinTreeNode<Integer> node95 = new Util_BinTreeNode<>(95, node100);
        Util_BinTreeNode<Integer> node105 = new Util_BinTreeNode<>(105, node100);


        node28.addLeft(node14);
        node28.addRight(node70);
        node14.addLeft(node7);
        node14.addRight(node21);
        node70.addLeft(node50);
        node70.addRight(node90);
        node7.addLeft(node5);
        node7.addRight(node10);
        node21.addLeft(node17);
        node21.addRight(node25);
        node50.addLeft(node40);
        node50.addRight(node55);
        node90.addLeft(node80);
        node90.addRight(node100);
        node5.addLeft(node1);
        node5.addRight(node6);
        node10.addLeft(node9);
        node10.addRight(node11);
        node17.addLeft(node16);
        node17.addRight(node18);
        node25.addLeft(node24);
        node25.addRight(node26);
        node40.addLeft(node38);
        node40.addRight(node42);
        node55.addLeft(node52);
        node55.addRight(node58);
        node80.addLeft(node71);
        node80.addRight(node85);
        node100.addLeft(node95);
        node100.addRight(node105);

        bigRoot = node28;

        Util_BinTreeNode<Integer> node300 = new Util_BinTreeNode<>(18, node17);
        node300.addLeft(node40);
    }
}
