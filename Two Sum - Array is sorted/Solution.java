import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        int last_index_complementary_value = 0;

        result[0] = 0;
        result[1] = numbers.length - 1;

        for (int i = result[1]; i >= 0; i--) {
            if (numbers[i] <= target) {
                last_index_complementary_value = target - numbers[i];
                if (i == 0) {
                    for (int j = 0; j < numbers.length; j++) {
                        if (numbers[j] == last_index_complementary_value) {
                            result[0] = j + 1;
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < i; j++) {
                        if (numbers[j] == last_index_complementary_value) {
                            result[0] = j + 1;
                            break;
                        }
                    }
                }
                result[1] = i + 1;
                break;
            }
        }

        Arrays.sort(result);
        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        // int[] numbers = { 3, 3, 3, 3, 3, 3, 4, 6, 6, 6, 13, 13, 13, 13, 13, 15, 16,
        // 16, 18, 18, 18, 18, 20, 20, 20, 21,
        // 21, 21, 21, 21, 25, 25, 25, 25, 25, 25, 28, 28, 28, 28, 28, 28, 33, 33, 33,
        // 33, 33, 33, 33, 34, 34, 39,
        // 40, 42, 42, 42, 43, 46, 47, 47, 49, 49, 49, 49, 50, 50, 50, 51, 52, 52, 53,
        // 55, 55, 57, 57, 59, 59, 59,
        // 59, 59, 60, 60, 60, 65, 65, 65, 65, 67, 67, 67, 68, 74, 74, 74, 74, 74, 74,
        // 74, 76, 76, 78, 78, 78, 79,
        // 79, 82, 84, 84, 84, 84, 84, 84, 84, 85, 86, 87, 87, 89, 89, 89, 91, 91, 93,
        // 93, 95, 95, 95, 95, 97, 98,
        // 99, 99, 99, 100, 102, 103, 103, 103, 104, 109, 109, 109, 109, 110, 112, 113,
        // 113, 117, 117, 117, 117,
        // 117, 119, 119, 120, 120, 121, 123, 124, 124, 125, 125, 128, 128, 128, 128,
        // 128, 129, 129, 131, 131, 131,
        // 135, 135, 135, 137, 137, 141, 141, 143, 145, 145, 145, 145, 147, 147, 147,
        // 148, 148, 149, 155, 155, 158,
        // 158, 158, 161, 161, 161, 161, 161, 161, 162, 164, 164, 164, 164, 166, 166,
        // 166, 166, 170, 170, 170, 170,
        // 173, 173, 173, 174, 174, 177, 177, 179, 179, 181, 181, 181, 182, 182, 182,
        // 184, 184, 184, 186, 186, 187,
        // 187, 188, 188, 190, 190, 190, 193, 196, 196, 197, 197, 198, 198, 198, 198,
        // 198, 199, 200, 200, 201, 201,
        // 205, 205, 205, 206, 206, 207, 209, 209, 211, 211, 212, 212, 216, 216, 216,
        // 216, 217, 217, 219, 221, 221,
        // 221, 221, 222, 222, 227, 227, 227, 227, 227, 227, 227, 227, 227, 227, 227,
        // 230, 230, 232, 233, 235, 236,
        // 236, 236, 236, 239, 241, 242, 244, 245, 245, 245, 246, 246, 247, 247, 247,
        // 247, 250, 250, 250, 250, 252,
        // 252, 255, 255, 255, 256, 256, 257, 260, 260, 260, 260, 260, 262, 262, 262,
        // 266, 266, 266, 267, 268, 268,
        // 275, 275, 275, 275, 275, 275, 275, 275, 275, 275, 275, 278, 278, 278, 281,
        // 281, 281, 285, 287, 287, 287,
        // 290, 292, 294, 294, 294, 295, 295, 298, 298, 298, 301, 302, 303, 305, 305,
        // 305, 307, 307, 310, 310, 311,
        // 313, 314, 314, 316, 316, 316, 316, 316, 316, 317, 318, 324, 324, 324, 324,
        // 324, 324, 326, 326, 326, 326,
        // 328, 328, 330, 330, 331, 334, 334, 336, 336, 337, 340, 340, 340, 340, 343,
        // 343, 343, 344, 344, 344, 348,
        // 348, 348, 352, 352, 352, 352, 354, 354, 355, 356, 359, 359, 362, 363, 363,
        // 363, 368, 369, 369, 369, 369,
        // 374, 374, 376, 376, 376, 378, 378, 378, 378, 382, 387, 387, 387, 387, 387,
        // 389, 389, 390, 390, 393, 393,
        // 395, 395, 397, 397, 398, 399, 399, 401, 401, 404, 404, 404, 406, 406, 406,
        // 406, 406, 406, 407, 407, 407,
        // 408, 408, 408, 412, 412, 412, 414, 416, 416, 416, 422, 426, 429, 429, 429,
        // 432, 432, 435, 435, 435, 438,
        // 438, 438, 438, 438, 439, 440, 441, 443, 446, 446, 446, 446, 446, 447, 447,
        // 448, 448, 451, 451, 451, 453,
        // 453, 453, 453, 453, 456, 456, 456, 456, 458, 458, 458, 458, 458, 459, 460,
        // 461, 462, 462, 465, 465, 468,
        // 468, 468, 469, 469, 469, 470, 471, 472, 473, 473, 473, 473, 476, 476, 476,
        // 477, 477, 479, 479, 479, 481,
        // 482, 483, 483, 486, 486, 487, 487, 487, 488, 488, 488, 489, 490, 491, 492,
        // 492, 492, 492, 493, 493, 493,
        // 493, 496, 496, 497, 498, 499, 500, 501, 501, 503, 503, 504, 504, 504, 505,
        // 505, 505, 507, 507, 508, 509,
        // 510, 510, 513, 514, 514, 516, 519, 520, 520, 521, 522, 522, 522, 523, 524,
        // 525, 525, 526, 528, 530, 530,
        // 531, 531, 532, 532, 532, 533, 537, 537, 538, 538, 539, 539, 539, 539, 541,
        // 541, 543, 543, 543, 546, 547,
        // 547, 548, 549, 549, 549, 549, 550, 551, 551, 552, 552, 554, 556, 556, 560,
        // 561, 562, 562, 562, 563, 563,
        // 563, 565, 565, 567, 568, 568, 569, 569, 569, 570, 570, 570, 571, 571, 571,
        // 572, 573, 574, 575, 575, 575,
        // 577, 577, 577, 578, 579, 580, 583, 583, 586, 588, 590, 590, 591, 591, 592,
        // 593, 594, 594, 595, 597, 597,
        // 598, 598, 599, 599, 600, 600, 601, 601, 601, 603, 603, 604, 604, 605, 605,
        // 607, 607, 608, 609, 609, 611,
        // 611, 611, 613, 615, 616, 617, 618, 619, 622, 622, 627, 628, 629, 629, 629,
        // 632, 634, 634, 634, 635, 636,
        // 637, 637, 639, 640, 641, 644, 645, 645, 646, 646, 646, 646, 647, 651, 651,
        // 653, 653, 654, 655, 656, 657,
        // 657, 658, 658, 660, 663, 665, 665, 667, 667, 667, 668, 669, 669, 670, 673,
        // 673, 674, 674, 677, 678, 681,
        // 682, 682, 683, 684, 684, 685, 686, 686, 687, 689, 690, 691, 691, 691, 693,
        // 693, 694, 694, 695, 698, 698,
        // 698, 700, 700, 701, 701, 702, 702, 703, 703, 703, 703, 703, 704, 704, 705,
        // 705, 706, 708, 710, 711, 712,
        // 713, 713, 715, 716, 716, 718, 718, 719, 720, 720, 721, 721, 722, 725, 726,
        // 726, 728, 729, 731, 731, 732,
        // 732, 733, 733, 734, 735, 736, 736, 736, 736, 737, 737, 737, 738, 738, 742,
        // 742, 742, 744, 746, 746, 747,
        // 748, 751, 751, 751, 756, 758, 758, 759, 759, 760, 761, 762, 763, 763, 763,
        // 766, 767, 767, 771, 772, 772,
        // 773, 775, 777, 779, 779, 779, 780, 780, 781, 781, 782, 784, 785, 786, 786,
        // 787, 787, 787, 788, 788, 788,
        // 788, 789, 790, 791, 792, 793, 793, 793, 794, 795, 797, 798, 798, 799, 799,
        // 801, 801, 802, 802, 802, 802,
        // 804, 805, 805, 805, 807, 809, 809, 809, 810, 810, 810, 811, 811, 811, 811,
        // 811, 812, 815, 816, 817, 817,
        // 819, 820, 821, 821, 822, 823, 823, 824, 826, 829, 829, 830, 832, 833, 833,
        // 834, 834, 835, 836, 839, 841,
        // 841, 841, 841, 841, 843, 844, 845, 846, 848, 850, 851, 851, 852, 853, 855,
        // 859, 859, 859, 861, 863, 865,
        // 865, 865, 866, 866, 868, 868, 868, 869, 871, 871, 871, 872, 874, 875, 877,
        // 877, 877, 878, 878, 879, 880,
        // 880, 880, 881, 882, 884, 885, 885, 885, 885, 886, 886, 888, 888, 889, 889,
        // 889, 889, 891, 891, 893, 894,
        // 895, 895, 895, 895, 896, 897, 898, 899, 903, 903, 903, 903, 904, 904, 905,
        // 909, 911, 913, 913, 914, 915,
        // 915, 916, 916, 916, 917, 917, 918, 918, 918, 919, 919, 920, 922, 923, 923,
        // 923, 925, 926, 928, 929, 929,
        // 931, 933, 933, 935, 936, 937, 937, 937, 938, 939, 939, 940, 940, 940, 940,
        // 942, 945, 947, 948, 949, 950,
        // 951, 952, 954, 957, 957, 958, 958, 960, 960, 961, 962, 962, 964, 966, 966,
        // 968, 969, 971, 971, 972, 973,
        // 973, 975, 977, 977, 978, 978, 979, 980, 981, 981, 981, 983, 985, 985, 985,
        // 986, 987, 990, 992, 995, 995,
        // 995, 995, 996, 996, 997, 997, 997, 997, 998, 998, 998, 998 };
        int[] numbers = { -1, 0 };
        int target = -1;
        int[] result = new int[2];
        result = s.twoSum(numbers, target);

        System.out.print(result[0] + " " + result[1]);

    }
}