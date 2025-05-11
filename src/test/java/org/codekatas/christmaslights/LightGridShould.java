package org.codekatas.christmaslights;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightGridShould {

    LightGrid lightGrid;

    @BeforeEach
    public void setUp() {
        lightGrid = new LightGrid();
    }


    @Test
    public void create_light_grid() {
        LightGrid lightGrid1 = new LightGrid();
        assertThat(true).isEqualTo(lightGrid1 instanceof LightGrid);
    }

    @Test
    public void turn_on_all_lights() {
        lightGrid.turnOn(CoordinatePair.of(0, 0, 999, 999));
    }

    @Test
    public void get_lights() {
        lightGrid.turnOn(CoordinatePair.of(0,0,999,0));
        assertThat(lightGrid.getLight(1, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(500, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(700, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(900, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(500, 500).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(700, 700).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(900, 900).isOn()).isEqualTo(false);
    }

    @Test
    public void toggle_lights_from_off_to_on() {
        lightGrid.toggle(CoordinatePair.of(0,0, 999, 0));
        assertThat(lightGrid.getLight(1, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(500, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(700, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(900, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(500, 500).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(700, 700).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(900, 900).isOn()).isEqualTo(false);
    }

    @Test
    public void toggle_lights_from_on_to_off() {
        lightGrid.turnOn(CoordinatePair.of(0,0,999,0));
        lightGrid.toggle(CoordinatePair.of(0,0, 999, 0));
        assertThat(lightGrid.getLight(1, 0).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(500, 0).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(700, 0).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(900, 0).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(500, 500).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(700, 700).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(900, 900).isOn()).isEqualTo(false);
    }

    @Test
    public void turn_off_middle_four_lights() {
        lightGrid.turnOn(CoordinatePair.of(0, 0, 999, 999));
        lightGrid.toggle(CoordinatePair.of(499, 499, 500, 500));
        assertThat(lightGrid.getLight(499, 499).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(499, 500).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(500, 499).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(500, 500).isOn()).isEqualTo(false);
        assertThat(lightGrid.getLight(0, 0).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(999, 999).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(498, 499).isOn()).isEqualTo(true);
        assertThat(lightGrid.getLight(500, 498).isOn()).isEqualTo(true);
    }

    @Test
    public void return_count_of_lights_that_are_on() {
        assertThat(lightGrid.countOn()).isEqualTo(0);

        lightGrid.turnOn(CoordinatePair.of(0, 0, 999, 999));
        assertThat(lightGrid.countOn()).isEqualTo(1000000);

        lightGrid.toggle(CoordinatePair.of(0, 0, 999, 999));
        assertThat(lightGrid.countOn()).isEqualTo(0);

        lightGrid.turnOn(CoordinatePair.of(887, 9, 959, 629));
        lightGrid.turnOn(CoordinatePair.of(454, 398, 844, 448));
        lightGrid.turnOff(CoordinatePair.of(539, 243, 559, 965));
        lightGrid.turnOff(CoordinatePair.of(370, 819, 676, 868));
        lightGrid.turnOff(CoordinatePair.of(145, 40, 370, 997));
        lightGrid.turnOff(CoordinatePair.of(301, 3, 808, 453));
        lightGrid.turnOn(CoordinatePair.of(351, 678, 951, 908));
        lightGrid.toggle(CoordinatePair.of(720, 196, 897, 994));
        lightGrid.toggle(CoordinatePair.of(831, 394, 904, 860));
        assertThat(lightGrid.countOn()).isEqualTo(230022);
    }

    @Test
    public void return_count_of_lights_with_larger_data() {

        lightGrid.turnOn(CoordinatePair.of(489, 959, 759, 964));
        lightGrid.turnOff(CoordinatePair.of(820, 516, 871, 914));
        lightGrid.turnOff(CoordinatePair.of(427, 423, 929, 502));
        lightGrid.turnOn(CoordinatePair.of(774, 14, 977, 877));
        lightGrid.turnOn(CoordinatePair.of(410, 146, 864, 337));
        lightGrid.turnOn(CoordinatePair.of(931, 331, 939, 812));
        lightGrid.turnOff(CoordinatePair.of(756, 53, 923, 339));
        lightGrid.turnOff(CoordinatePair.of(313, 787, 545, 979));
        lightGrid.turnOff(CoordinatePair.of(12, 823, 102, 934));
        lightGrid.toggle(CoordinatePair.of(756, 965, 812, 992));
        lightGrid.turnOff(CoordinatePair.of(743, 684, 789, 958));
        lightGrid.toggle(CoordinatePair.of(120, 314, 745, 489));
        lightGrid.toggle(CoordinatePair.of(692, 845, 866, 994));
        lightGrid.turnOff(CoordinatePair.of(587, 176, 850, 273));
        lightGrid.turnOff(CoordinatePair.of(674, 321, 793, 388));
        lightGrid.toggle(CoordinatePair.of(749, 672, 973, 965));
        lightGrid.turnOn(CoordinatePair.of(943, 30, 990, 907));
        lightGrid.turnOn(CoordinatePair.of(296, 50, 729, 664));
        lightGrid.turnOn(CoordinatePair.of(212, 957, 490, 987));
        lightGrid.toggle(CoordinatePair.of(171, 31, 688, 88));
        lightGrid.turnOff(CoordinatePair.of(991, 989, 994, 998));
        lightGrid.turnOff(CoordinatePair.of(913, 943, 958, 953));
        lightGrid.turnOff(CoordinatePair.of(278, 258, 367, 386));
        lightGrid.toggle(CoordinatePair.of(275, 796, 493, 971));
        lightGrid.turnOff(CoordinatePair.of(70, 873, 798, 923));
        lightGrid.toggle(CoordinatePair.of(258, 985, 663, 998));
        lightGrid.turnOn(CoordinatePair.of(601, 259, 831, 486));
        lightGrid.turnOff(CoordinatePair.of(914, 94, 941, 102));
        lightGrid.turnOff(CoordinatePair.of(558, 161, 994, 647));
        lightGrid.turnOn(CoordinatePair.of(119, 662, 760, 838));
        lightGrid.toggle(CoordinatePair.of(378, 775, 526, 852));
        lightGrid.turnOff(CoordinatePair.of(384, 670, 674, 972));
        lightGrid.turnOff(CoordinatePair.of(249, 41, 270, 936));
        lightGrid.turnOn(CoordinatePair.of(614, 742, 769, 780));
        lightGrid.turnOn(CoordinatePair.of(427, 70, 575, 441));
        lightGrid.turnOn(CoordinatePair.of(410, 478, 985, 753));
        lightGrid.turnOff(CoordinatePair.of(619, 46, 931, 342));
        lightGrid.turnOn(CoordinatePair.of(284, 55, 768, 922));
        lightGrid.turnOff(CoordinatePair.of(40, 592, 728, 685));
        lightGrid.turnOn(CoordinatePair.of(825, 291, 956, 950));
        lightGrid.turnOn(CoordinatePair.of(147, 843, 592, 909));
        lightGrid.turnOff(CoordinatePair.of(218, 675, 972, 911));
        lightGrid.toggle(CoordinatePair.of(249, 291, 350, 960));
        lightGrid.turnOff(CoordinatePair.of(556, 80, 967, 675));
        lightGrid.toggle(CoordinatePair.of(609, 148, 968, 279));
        lightGrid.toggle(CoordinatePair.of(217, 605, 961, 862));
        lightGrid.toggle(CoordinatePair.of(407, 177, 548, 910));
        lightGrid.toggle(CoordinatePair.of(400, 936, 599, 938));
        lightGrid.turnOff(CoordinatePair.of(721, 101, 925, 455));
        lightGrid.turnOn(CoordinatePair.of(268, 631, 735, 814));
        lightGrid.toggle(CoordinatePair.of(549, 969, 612, 991));
        lightGrid.toggle(CoordinatePair.of(553, 268, 689, 432));
        lightGrid.turnOff(CoordinatePair.of(817, 668, 889, 897));
        lightGrid.toggle(CoordinatePair.of(801, 544, 858, 556));
        lightGrid.toggle(CoordinatePair.of(615, 729, 832, 951));
        lightGrid.turnOff(CoordinatePair.of(427, 477, 958, 948));
        lightGrid.turnOn(CoordinatePair.of(164, 49, 852, 946));
        lightGrid.turnOn(CoordinatePair.of(542, 449, 774, 776));
        lightGrid.turnOff(CoordinatePair.of(923, 196, 980, 446));
        lightGrid.toggle(CoordinatePair.of(90, 310, 718, 846));
        lightGrid.turnOff(CoordinatePair.of(657, 215, 744, 252));
        lightGrid.turnOff(CoordinatePair.of(800, 239, 811, 712));
        lightGrid.turnOn(CoordinatePair.of(502, 90, 619, 760));
        lightGrid.toggle(CoordinatePair.of(649, 512, 862, 844));
        lightGrid.turnOff(CoordinatePair.of(334, 903, 823, 935));
        lightGrid.turnOff(CoordinatePair.of(630, 233, 839, 445));
        lightGrid.turnOn(CoordinatePair.of(713, 67, 839, 865));
        lightGrid.turnOn(CoordinatePair.of(932, 50, 982, 411));
        lightGrid.turnOff(CoordinatePair.of(480, 729, 984, 910));
        lightGrid.turnOn(CoordinatePair.of(100, 219, 796, 395));
        lightGrid.turnOn(CoordinatePair.of(758, 108, 850, 950));
        lightGrid.turnOff(CoordinatePair.of(427, 276, 439, 938));
        lightGrid.turnOn(CoordinatePair.of(178, 284, 670, 536));
        lightGrid.toggle(CoordinatePair.of(540, 27, 625, 102));
        lightGrid.turnOff(CoordinatePair.of(906, 722, 936, 948));
        lightGrid.toggle(CoordinatePair.of(345, 418, 859, 627));
        lightGrid.toggle(CoordinatePair.of(175, 775, 580, 781));
        lightGrid.toggle(CoordinatePair.of(863, 28, 929, 735));
        lightGrid.turnOff(CoordinatePair.of(824, 858, 905, 973));
        lightGrid.toggle(CoordinatePair.of(752, 312, 863, 425));
        lightGrid.turnOn(CoordinatePair.of(985, 716, 988, 852));
        lightGrid.turnOff(CoordinatePair.of(68, 504, 763, 745));
        lightGrid.toggle(CoordinatePair.of(76, 209, 810, 720));
        lightGrid.turnOff(CoordinatePair.of(657, 607, 676, 664));
        lightGrid.toggle(CoordinatePair.of(596, 869, 896, 921));
        lightGrid.turnOff(CoordinatePair.of(915, 411, 968, 945));
        lightGrid.turnOff(CoordinatePair.of(368, 39, 902, 986));
        lightGrid.turnOn(CoordinatePair.of(11, 549, 393, 597));
        lightGrid.turnOff(CoordinatePair.of(842, 893, 976, 911));
        lightGrid.toggle(CoordinatePair.of(274, 106, 581, 329));
        lightGrid.toggle(CoordinatePair.of(406, 403, 780, 950));
        lightGrid.toggle(CoordinatePair.of(408, 988, 500, 994));
        lightGrid.toggle(CoordinatePair.of(217, 73, 826, 951));
        lightGrid.turnOn(CoordinatePair.of(917, 872, 961, 911));
        lightGrid.toggle(CoordinatePair.of(394, 34, 510, 572));
        lightGrid.toggle(CoordinatePair.of(424, 603, 583, 626));
        lightGrid.toggle(CoordinatePair.of(106, 159, 755, 738));
        lightGrid.turnOff(CoordinatePair.of(244, 610, 472, 709));
        lightGrid.turnOn(CoordinatePair.of(350, 265, 884, 690));
        lightGrid.turnOn(CoordinatePair.of(688, 184, 928, 280));
        lightGrid.toggle(CoordinatePair.of(279, 443, 720, 797));
        lightGrid.turnOff(CoordinatePair.of(615, 493, 888, 610));
        lightGrid.toggle(CoordinatePair.of(118, 413, 736, 632));
        lightGrid.turnOn(CoordinatePair.of(798, 782, 829, 813));
        lightGrid.turnOff(CoordinatePair.of(250, 934, 442, 972));
        lightGrid.turnOn(CoordinatePair.of(68, 503, 400, 949));
        lightGrid.toggle(CoordinatePair.of(297, 482, 313, 871));
        lightGrid.toggle(CoordinatePair.of(710, 3, 839, 859));
        lightGrid.turnOn(CoordinatePair.of(125, 300, 546, 888));
        lightGrid.toggle(CoordinatePair.of(482, 39, 584, 159));
        lightGrid.turnOff(CoordinatePair.of(536, 89, 765, 962));
        lightGrid.turnOn(CoordinatePair.of(530, 518, 843, 676));
        lightGrid.turnOn(CoordinatePair.of(994, 467, 994, 676));
        lightGrid.turnOn(CoordinatePair.of(623, 628, 744, 927));
        lightGrid.toggle(CoordinatePair.of(704, 912, 837, 983));
        lightGrid.turnOn(CoordinatePair.of(154, 364, 517, 412));
        lightGrid.toggle(CoordinatePair.of(344, 409, 780, 524));
        lightGrid.turnOff(CoordinatePair.of(578, 740, 725, 879));
        lightGrid.turnOn(CoordinatePair.of(251, 933, 632, 957));
        lightGrid.turnOn(CoordinatePair.of(827, 705, 971, 789));
        lightGrid.toggle(CoordinatePair.of(191, 282, 470, 929));
        lightGrid.toggle(CoordinatePair.of(324, 525, 446, 867));
        lightGrid.toggle(CoordinatePair.of(534, 343, 874, 971));
        lightGrid.toggle(CoordinatePair.of(550, 650, 633, 980));
        lightGrid.toggle(CoordinatePair.of(837, 404, 881, 915));
        lightGrid.toggle(CoordinatePair.of(338, 881, 845, 905));
        lightGrid.turnOn(CoordinatePair.of(469, 462, 750, 696));
        lightGrid.turnOn(CoordinatePair.of(741, 703, 892, 870));
        lightGrid.turnOff(CoordinatePair.of(570, 215, 733, 562));
        lightGrid.turnOn(CoordinatePair.of(445, 576, 870, 775));
        lightGrid.turnOn(CoordinatePair.of(466, 747, 554, 878));
        lightGrid.turnOff(CoordinatePair.of(820, 453, 868, 712));
        lightGrid.turnOff(CoordinatePair.of(892, 706, 938, 792));
        lightGrid.turnOff(CoordinatePair.of(300, 238, 894, 746));
        lightGrid.turnOff(CoordinatePair.of(306, 44, 457, 444));
        lightGrid.turnOff(CoordinatePair.of(912, 569, 967, 963));
        lightGrid.toggle(CoordinatePair.of(109, 756, 297, 867));
        lightGrid.turnOn(CoordinatePair.of(37, 546, 41, 951));
        lightGrid.turnOn(CoordinatePair.of(321, 637, 790, 910));
        lightGrid.toggle(CoordinatePair.of(66, 50, 579, 301));
        lightGrid.toggle(CoordinatePair.of(933, 221, 933, 791));
        lightGrid.turnOn(CoordinatePair.of(486, 676, 878, 797));
        lightGrid.turnOn(CoordinatePair.of(417, 231, 556, 317));
        lightGrid.toggle(CoordinatePair.of(904, 468, 981, 873));
        lightGrid.turnOn(CoordinatePair.of(417, 675, 749, 712));
        lightGrid.turnOn(CoordinatePair.of(692, 371, 821, 842));
        lightGrid.toggle(CoordinatePair.of(324, 73, 830, 543));
        lightGrid.turnOn(CoordinatePair.of(912, 490, 977, 757));
        lightGrid.turnOff(CoordinatePair.of(634, 872, 902, 949));
        lightGrid.toggle(CoordinatePair.of(266, 779, 870, 798));
        lightGrid.turnOn(CoordinatePair.of(772, 982, 990, 996));
        lightGrid.turnOff(CoordinatePair.of(607, 46, 798, 559));
        lightGrid.turnOn(CoordinatePair.of(295, 602, 963, 987));
        lightGrid.turnOn(CoordinatePair.of(657, 86, 944, 742));
        lightGrid.turnOff(CoordinatePair.of(334, 639, 456, 821));
        lightGrid.turnOff(CoordinatePair.of(997, 667, 997, 670));
        lightGrid.turnOff(CoordinatePair.of(725, 832, 951, 945));
        lightGrid.turnOff(CoordinatePair.of(30, 120, 952, 984));
        lightGrid.turnOn(CoordinatePair.of(860, 965, 917, 976));
        lightGrid.toggle(CoordinatePair.of(471, 997, 840, 998));
        lightGrid.turnOff(CoordinatePair.of(319, 307, 928, 504));
        lightGrid.toggle(CoordinatePair.of(823, 631, 940, 908));
        lightGrid.toggle(CoordinatePair.of(969, 984, 981, 993));
        lightGrid.turnOff(CoordinatePair.of(691, 319, 865, 954));
        lightGrid.toggle(CoordinatePair.of(911, 926, 938, 929));
        lightGrid.turnOn(CoordinatePair.of(953, 937, 968, 991));
        lightGrid.toggle(CoordinatePair.of(914, 643, 975, 840));
        lightGrid.turnOn(CoordinatePair.of(266, 982, 436, 996));
        lightGrid.turnOff(CoordinatePair.of(101,896,321,932));
        lightGrid.turnOff(CoordinatePair.of(193,852,751,885));
        lightGrid.turnOff(CoordinatePair.of(576,532,863,684));
        lightGrid.turnOn(CoordinatePair.of(761,456,940,783));
        lightGrid.turnOn(CoordinatePair.of(20,290,398,933));
        lightGrid.turnOff(CoordinatePair.of(435,335,644,652));
        lightGrid.turnOn(CoordinatePair.of(830,569,905,770));
        lightGrid.turnOff(CoordinatePair.of(630,517,905,654));
        lightGrid.turnOn(CoordinatePair.of(664,53,886,976));
        lightGrid.toggle(CoordinatePair.of(275,416,408,719));
        lightGrid.turnOn(CoordinatePair.of(370,621,515,793));
        lightGrid.turnOn(CoordinatePair.of(483,373,654,749));
        lightGrid.turnOn(CoordinatePair.of(656,786,847,928));
        lightGrid.turnOff(CoordinatePair.of(532,752,945,974));
        lightGrid.toggle(CoordinatePair.of(301,150,880,792));
        lightGrid.turnOff(CoordinatePair.of(951,488,958,952));
        lightGrid.turnOn(CoordinatePair.of(207,729,882,828));
        lightGrid.toggle(CoordinatePair.of(694,532,973,961));
        lightGrid.toggle(CoordinatePair.of(676,639,891,802));
        lightGrid.turnOff(CoordinatePair.of(653,6,905,519));
        lightGrid.toggle(CoordinatePair.of(391,109,418,312));
        lightGrid.turnOn(CoordinatePair.of(877,423,957,932));
        lightGrid.turnOn(CoordinatePair.of(340,145,563,522));
        lightGrid.turnOff(CoordinatePair.of(978,467,988,895));
        lightGrid.turnOff(CoordinatePair.of(396,418,420,885));
        lightGrid.turnOff(CoordinatePair.of(31,308,816,316));
        lightGrid.turnOn(CoordinatePair.of(107,675,758,824));
        lightGrid.turnOn(CoordinatePair.of(61,82,789,876));
        lightGrid.turnOn(CoordinatePair.of(750,743,754,760));
        lightGrid.toggle(CoordinatePair.of(88,733,736,968));
        lightGrid.turnOff(CoordinatePair.of(754,349,849,897));
        lightGrid.toggle(CoordinatePair.of(157,50,975,781));
        lightGrid.turnOff(CoordinatePair.of(230,231,865,842));
        lightGrid.turnOff(CoordinatePair.of(516,317,630,329));
        lightGrid.turnOff(CoordinatePair.of(697,820,829,903));
        lightGrid.turnOn(CoordinatePair.of(218,250,271,732));
        lightGrid.toggle(CoordinatePair.of(56,167,404,431));
        lightGrid.toggle(CoordinatePair.of(626,891,680,927));
        lightGrid.toggle(CoordinatePair.of(370,207,791,514));
        lightGrid.toggle(CoordinatePair.of(860,74,949,888));
        lightGrid.turnOn(CoordinatePair.of(416,527,616,541));
        lightGrid.turnOff(CoordinatePair.of(745,449,786,908));
        lightGrid.turnOn(CoordinatePair.of(485,554,689,689));
        lightGrid.turnOn(CoordinatePair.of(586,62,693,141));
        lightGrid.toggle(CoordinatePair.of(506,759,768,829));
        lightGrid.turnOn(CoordinatePair.of(473,109,929,166));
        lightGrid.turnOn(CoordinatePair.of(760,617,773,789));
        lightGrid.toggle(CoordinatePair.of(595,683,618,789));
        lightGrid.turnOff(CoordinatePair.of(210,775,825,972));
        lightGrid.toggle(CoordinatePair.of(12,426,179,982));
        lightGrid.turnOn(CoordinatePair.of(774,539,778,786));
        lightGrid.turnOn(CoordinatePair.of(102,498,121,807));
        lightGrid.turnOff(CoordinatePair.of(706,897,834,965));
        lightGrid.turnOff(CoordinatePair.of(678,529,824,627));
        lightGrid.turnOn(CoordinatePair.of(7,765,615,870));
        lightGrid.turnOff(CoordinatePair.of(730,872,974,943));
        lightGrid.turnOff(CoordinatePair.of(595,626,836,711));
        lightGrid.turnOff(CoordinatePair.of(215,424,841,959));
        lightGrid.toggle(CoordinatePair.of(341,780,861,813));
        lightGrid.toggle(CoordinatePair.of(507,503,568,822));
        lightGrid.turnOn(CoordinatePair.of(252,603,349,655));
        lightGrid.toggle(CoordinatePair.of(93,521,154,834));
        lightGrid.turnOn(CoordinatePair.of(565,682,951,954));
        lightGrid.turnOn(CoordinatePair.of(544,318,703,418));
        lightGrid.toggle(CoordinatePair.of(756,953,891,964));
        lightGrid.turnOn(CoordinatePair.of(531,123,856,991));
        lightGrid.turnOn(CoordinatePair.of(148,315,776,559));
        lightGrid.turnOff(CoordinatePair.of(925,835,963,971));
        lightGrid.turnOn(CoordinatePair.of(895,944,967,964));
        lightGrid.turnOff(CoordinatePair.of(102,527,650,747));
        lightGrid.toggle(CoordinatePair.of(626,105,738,720));
        lightGrid.turnOff(CoordinatePair.of(160,75,384,922));
        lightGrid.toggle(CoordinatePair.of(813,724,903,941));
        lightGrid.turnOn(CoordinatePair.of(207,107,982,849));
        lightGrid.toggle(CoordinatePair.of(750,505,961,697));
        lightGrid.toggle(CoordinatePair.of(105,410,885,819));
        lightGrid.turnOn(CoordinatePair.of(226,104,298,283));
        lightGrid.turnOff(CoordinatePair.of(224,604,508,762));
        lightGrid.turnOn(CoordinatePair.of(477,368,523,506));
        lightGrid.turnOff(CoordinatePair.of(477,901,627,936));
        lightGrid.turnOff(CoordinatePair.of(887,131,889,670));
        lightGrid.turnOn(CoordinatePair.of(896,994,938,999));
        lightGrid.toggle(CoordinatePair.of(401,580,493,728));
        lightGrid.toggle(CoordinatePair.of(987,184,991,205));
        lightGrid.turnOn(CoordinatePair.of(821,643,882,674));
        lightGrid.toggle(CoordinatePair.of(784,940,968,959));
        lightGrid.turnOff(CoordinatePair.of(251,293,274,632));
        lightGrid.turnOff(CoordinatePair.of(339,840,341,844));
        lightGrid.turnOff(CoordinatePair.of(675,351,675,836));
        lightGrid.toggle(CoordinatePair.of(918,857,944,886));
        lightGrid.toggle(CoordinatePair.of(70,253,918,736));
        lightGrid.turnOff(CoordinatePair.of(612,604,772,680));
        lightGrid.turnOff(CoordinatePair.of(277,40,828,348));
        lightGrid.toggle(CoordinatePair.of(692,139,698,880));
        lightGrid.toggle(CoordinatePair.of(124,446,883,453));
        lightGrid.toggle(CoordinatePair.of(969,932,990,945));
        lightGrid.toggle(CoordinatePair.of(855,692,993,693));
        lightGrid.toggle(CoordinatePair.of(722,472,887,899));
        lightGrid.toggle(CoordinatePair.of(978,149,985,442));
        lightGrid.toggle(CoordinatePair.of(837,540,916,889));
        lightGrid.turnOff(CoordinatePair.of(612,2,835,82));
        lightGrid.toggle(CoordinatePair.of(560,767,878,856));
        lightGrid.turnOn(CoordinatePair.of(461,734,524,991));
        lightGrid.toggle(CoordinatePair.of(206,824,976,912));
        lightGrid.turnOn(CoordinatePair.of(826,610,879,892));
        lightGrid.turnOn(CoordinatePair.of(577,699,956,933));
        lightGrid.turnOff(CoordinatePair.of(9,250,50,529));
        lightGrid.turnOff(CoordinatePair.of(77,657,817,677));
        lightGrid.turnOn(CoordinatePair.of(68,419,86,426));
        lightGrid.turnOn(CoordinatePair.of(991,720,992,784));
        lightGrid.turnOn(CoordinatePair.of(668,20,935,470));
        lightGrid.turnOff(CoordinatePair.of(133,418,613,458));
        lightGrid.turnOff(CoordinatePair.of(487,286,540,328));
        lightGrid.toggle(CoordinatePair.of(247,874,840,955));
        lightGrid.toggle(CoordinatePair.of(301,808,754,970));
        lightGrid.turnOff(CoordinatePair.of(34,194,578,203));
        lightGrid.turnOff(CoordinatePair.of(451,49,492,921));
        lightGrid.turnOn(CoordinatePair.of(907,256,912,737));
        lightGrid.turnOff(CoordinatePair.of(479,305,702,587));
        lightGrid.turnOn(CoordinatePair.of(545,583,732,749));
        lightGrid.toggle(CoordinatePair.of(11,16,725,868));
        lightGrid.turnOn(CoordinatePair.of(965,343,986,908));
        lightGrid.turnOn(CoordinatePair.of(674,953,820,965));
        lightGrid.toggle(CoordinatePair.of(398,147,504,583));
        lightGrid.turnOff(CoordinatePair.of(778,194,898,298));
        lightGrid.turnOn(CoordinatePair.of(179,140,350,852));
        lightGrid.turnOff(CoordinatePair.of(241,118,530,832));
        lightGrid.turnOff(CoordinatePair.of(41,447,932,737));
        lightGrid.turnOff(CoordinatePair.of(820,663,832,982));
        lightGrid.turnOn(CoordinatePair.of(550,460,964,782));
        lightGrid.turnOn(CoordinatePair.of(31,760,655,892));
        lightGrid.toggle(CoordinatePair.of(628,958,811,992));
        assertThat(lightGrid.countOn()).isEqualTo(569999);
    }

}