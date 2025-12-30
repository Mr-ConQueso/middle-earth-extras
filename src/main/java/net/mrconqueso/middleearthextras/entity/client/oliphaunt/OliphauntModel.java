package net.mrconqueso.middleearthextras.entity.client.oliphaunt;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.entity.custom.OliphauntEntity;

public class OliphauntModel<T extends OliphauntEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer OLIPHAUNT = new EntityModelLayer(Identifier.of(MiddleEarthExtras.MOD_ID, "oliphaunt"), "main");
    public static final EntityModelLayer OLIPHAUNT_ARMOR = new EntityModelLayer(Identifier.of(MiddleEarthExtras.MOD_ID, "oliphaunt_armor"), "armor");

    // Made with Blockbench 4.11.2
    // Exported for Minecraft version 1.17+ for Yarn
    // Paste this class into your mod and generate all required imports

    private final ModelPart oliphaunt;
    private final ModelPart head;
    private final ModelPart howdah;
    private final ModelPart level3;
    private final ModelPart columns2;
    private final ModelPart level2;
    private final ModelPart columns;
    private final ModelPart level1;
    private final ModelPart harness;
    private final ModelPart front;

    public OliphauntModel(ModelPart root) {
        this.oliphaunt = root.getChild("oliphaunt");
        this.head = this.oliphaunt.getChild("head");
        this.howdah = this.oliphaunt.getChild("howdah");
        this.level3 = this.howdah.getChild("level3");
        this.columns2 = this.level3.getChild("columns2");
        this.level2 = this.howdah.getChild("level2");
        this.columns = this.level2.getChild("columns");
        this.level1 = this.howdah.getChild("level1");
        this.harness = this.howdah.getChild("harness");
        this.front = this.harness.getChild("front");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData oliphaunt = modelPartData.addChild("oliphaunt", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = oliphaunt.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0836F, -180.9082F, -114.7281F));

        ModelPartData _gltfNode_20_r1 = head.addChild("_gltfNode_20_r1", ModelPartBuilder.create().uv(1286, 1347).cuboid(33.6428F, 0.3227F, 4.1643F, 33.0F, 33.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(12.4114F, -22.288F, -25.4835F, 3.0975F, -0.4193F, -2.7306F));

        ModelPartData _gltfNode_97_r1 = head.addChild("_gltfNode_97_r1", ModelPartBuilder.create().uv(622, 1269).cuboid(-8.2138F, -6.0627F, -1.7507F, 12.0F, 8.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(-9.1624F, 10.0936F, -53.9015F, 2.1018F, -0.6408F, -2.6878F));

        ModelPartData _gltfNode_94_r1 = head.addChild("_gltfNode_94_r1", ModelPartBuilder.create().uv(110, 1269).cuboid(-3.8843F, -6.0627F, -1.7507F, 12.0F, 8.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(8.9953F, 10.0936F, -53.9015F, 2.1018F, 0.6408F, 2.6878F));

        ModelPartData _gltfNode_91_r1 = head.addChild("_gltfNode_91_r1", ModelPartBuilder.create().uv(1266, 872).cuboid(-8.2138F, -6.0627F, -1.7507F, 12.0F, 8.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(-39.8904F, 67.1808F, -38.1952F, 2.1891F, -0.6408F, -2.6878F));

        ModelPartData _gltfNode_89_r1 = head.addChild("_gltfNode_89_r1", ModelPartBuilder.create().uv(762, 1203).cuboid(21.066F, 27.6684F, -9.0145F, 14.0F, 14.0F, 56.0F, new Dilation(0.0F)), ModelTransform.of(-10.1069F, 16.576F, -58.4648F, 2.1287F, -0.4147F, -2.9973F));

        ModelPartData _gltfNode_86_r1 = head.addChild("_gltfNode_86_r1", ModelPartBuilder.create().uv(952, 1251).cuboid(-3.8844F, -6.0627F, -1.7507F, 12.0F, 8.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(39.7233F, 67.1808F, -38.1952F, 2.1891F, 0.6408F, 2.6878F));

        ModelPartData _gltfNode_84_r1 = head.addChild("_gltfNode_84_r1", ModelPartBuilder.create().uv(622, 1199).cuboid(-35.066F, 27.6684F, -9.0145F, 14.0F, 14.0F, 56.0F, new Dilation(0.0F)), ModelTransform.of(9.9397F, 16.576F, -58.4648F, 2.1287F, 0.4147F, 2.9973F));

        ModelPartData _gltfNode_77_r1 = head.addChild("_gltfNode_77_r1", ModelPartBuilder.create().uv(966, 1123).cuboid(4.0278F, -10.3246F, 2.9574F, 7.0F, 11.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(-104.4655F, 20.5145F, -320.1132F, 3.0109F, -0.513F, 2.9F));

        ModelPartData _gltfNode_75_r1 = head.addChild("_gltfNode_75_r1", ModelPartBuilder.create().uv(1106, 1311).cuboid(1.471F, -6.3045F, 38.3224F, 11.0F, 11.0F, 35.0F, new Dilation(0.0F)), ModelTransform.of(-115.4047F, 17.0164F, -248.8787F, 3.099F, 0.1364F, 2.775F));

        ModelPartData _gltfNode_73_r1 = head.addChild("_gltfNode_73_r1", ModelPartBuilder.create().uv(1294, 356).cuboid(-1.529F, -9.3046F, -3.5673F, 14.0F, 14.0F, 42.0F, new Dilation(0.0F)), ModelTransform.of(-112.6129F, 26.7242F, -251.2032F, -3.0006F, 0.1123F, 2.9155F));

        ModelPartData _gltfNode_71_r1 = head.addChild("_gltfNode_71_r1", ModelPartBuilder.create().uv(1250, 1244).cuboid(-2.9129F, -8.2818F, -3.0614F, 14.0F, 14.0F, 53.0F, new Dilation(0.0F)), ModelTransform.of(-116.679F, 54.3072F, -217.5609F, -2.7455F, -0.4148F, -2.3207F));

        ModelPartData _gltfNode_69_r1 = head.addChild("_gltfNode_69_r1", ModelPartBuilder.create().uv(1270, 184).cuboid(-5.9592F, -8.5414F, 2.6048F, 14.0F, 14.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(-105.8493F, 80.7933F, -183.7792F, -2.8225F, -0.7078F, -2.4743F));

        ModelPartData _gltfNode_67_r1 = head.addChild("_gltfNode_67_r1", ModelPartBuilder.create().uv(798, 1123).cuboid(1.1623F, -6.6144F, -27.2897F, 18.0F, 14.0F, 66.0F, new Dilation(0.0F)), ModelTransform.of(-59.7317F, 95.4696F, -133.481F, 2.9586F, -0.5611F, -2.8138F));

        ModelPartData _gltfNode_65_r1 = head.addChild("_gltfNode_65_r1", ModelPartBuilder.create().uv(1294, 300).cuboid(-14.0235F, -11.8185F, 3.0499F, 14.0F, 14.0F, 42.0F, new Dilation(0.0F)), ModelTransform.of(-96.3123F, 95.3865F, -152.5756F, -2.8447F, -0.5611F, -2.8138F));

        ModelPartData _gltfNode_63_r1 = head.addChild("_gltfNode_63_r1", ModelPartBuilder.create().uv(278, 1240).cuboid(-8.2147F, -9.5634F, -1.7467F, 19.0F, 15.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(-22.3904F, 69.1655F, -83.6518F, 2.1891F, -0.6408F, -2.6878F));

        ModelPartData _gltfNode_61_r1 = head.addChild("_gltfNode_61_r1", ModelPartBuilder.create().uv(1196, 0).cuboid(21.066F, 24.1684F, -9.0145F, 21.0F, 21.0F, 56.0F, new Dilation(0.0F)), ModelTransform.of(7.3931F, 18.5608F, -103.9214F, 2.1287F, -0.4147F, -2.9973F));

        ModelPartData _gltfNode_24_r1 = head.addChild("_gltfNode_24_r1", ModelPartBuilder.create().uv(424, 862).cuboid(-39.5875F, -6.6037F, -13.3964F, 50.0F, 19.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(-12.5786F, -42.9404F, -29.8886F, -2.9234F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_22_r1 = head.addChild("_gltfNode_22_r1", ModelPartBuilder.create().uv(1350, 0).cuboid(33.6428F, 0.3227F, 4.1643F, 33.0F, 33.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(70.7211F, -57.2114F, 10.5124F, 3.0975F, 0.4193F, 2.7306F));

        ModelPartData _gltfNode_18_r1 = head.addChild("_gltfNode_18_r1", ModelPartBuilder.create().uv(334, 635).cuboid(-33.68F, -257.0374F, 104.4563F, 67.0F, 83.0F, 71.0F, new Dilation(0.0F)), ModelTransform.of(-0.0836F, 208.3525F, 114.1564F, 3.098F, 0.0F, -3.1416F));

        ModelPartData _gltfNode_54_r1 = head.addChild("_gltfNode_54_r1", ModelPartBuilder.create().uv(952, 1309).cuboid(-12.9418F, -6.3045F, 38.3224F, 11.0F, 11.0F, 35.0F, new Dilation(0.0F)), ModelTransform.of(115.2375F, 17.0164F, -248.8787F, 3.099F, -0.1364F, -2.775F));

        ModelPartData _gltfNode_52_r1 = head.addChild("_gltfNode_52_r1", ModelPartBuilder.create().uv(158, 984).cuboid(-11.0278F, -10.3246F, 2.9574F, 7.0F, 11.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(104.2984F, 20.5145F, -320.1132F, 3.0109F, 0.513F, -2.9F));

        ModelPartData _gltfNode_50_r1 = head.addChild("_gltfNode_50_r1", ModelPartBuilder.create().uv(746, 1273).cuboid(-12.4693F, -9.3046F, -3.5673F, 14.0F, 14.0F, 42.0F, new Dilation(0.0F)), ModelTransform.of(112.4458F, 26.7242F, -251.2032F, -3.0006F, -0.1123F, -2.9155F));

        ModelPartData _gltfNode_48_r1 = head.addChild("_gltfNode_48_r1", ModelPartBuilder.create().uv(1116, 1244).cuboid(-11.087F, -8.2818F, -3.0614F, 14.0F, 14.0F, 53.0F, new Dilation(0.0F)), ModelTransform.of(116.5119F, 54.3072F, -217.5609F, -2.7455F, 0.4148F, 2.3207F));

        ModelPartData _gltfNode_46_r1 = head.addChild("_gltfNode_46_r1", ModelPartBuilder.create().uv(1270, 124).cuboid(-8.0408F, -8.5414F, 2.6048F, 14.0F, 14.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(105.6822F, 80.7933F, -183.7792F, -2.8225F, 0.7078F, 2.4743F));

        ModelPartData _gltfNode_44_r1 = head.addChild("_gltfNode_44_r1", ModelPartBuilder.create().uv(158, 1116).cuboid(-19.6623F, -6.6144F, -27.2897F, 18.0F, 14.0F, 66.0F, new Dilation(0.0F)), ModelTransform.of(59.5645F, 95.4696F, -133.481F, 2.9586F, 0.5611F, 2.8138F));

        ModelPartData _gltfNode_42_r1 = head.addChild("_gltfNode_42_r1", ModelPartBuilder.create().uv(1272, 244).cuboid(0.0235F, -11.8185F, 3.0499F, 14.0F, 14.0F, 42.0F, new Dilation(0.0F)), ModelTransform.of(96.1451F, 95.3865F, -152.5756F, -2.8447F, 0.5611F, 2.8138F));

        ModelPartData _gltfNode_40_r1 = head.addChild("_gltfNode_40_r1", ModelPartBuilder.create().uv(1234, 617).cuboid(-10.8853F, -9.5634F, -1.7467F, 19.0F, 15.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(22.2233F, 69.1655F, -83.6518F, 2.1891F, 0.6408F, 2.6878F));

        ModelPartData _gltfNode_38_r1 = head.addChild("_gltfNode_38_r1", ModelPartBuilder.create().uv(1116, 1167).cuboid(-42.066F, 24.1684F, -9.0145F, 21.0F, 21.0F, 56.0F, new Dilation(0.0F)), ModelTransform.of(-7.5603F, 18.5608F, -103.9214F, 2.1287F, 0.4147F, 2.9973F));

        ModelPartData _gltfNode_26_r1 = head.addChild("_gltfNode_26_r1", ModelPartBuilder.create().uv(1060, 626).cuboid(-25.01F, -58.0F, -33.32F, 50.0F, 58.0F, 37.0F, new Dilation(0.0F)), ModelTransform.of(-0.0836F, 25.6636F, -94.2426F, -2.7489F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_28_r1 = head.addChild("_gltfNode_28_r1", ModelPartBuilder.create().uv(0, 1126).cuboid(-16.34F, -195.6357F, 171.0767F, 33.0F, 79.0F, 33.0F, new Dilation(0.0F)), ModelTransform.of(-0.0836F, 208.3526F, 114.1561F, 3.098F, 0.0F, -3.1416F));

        ModelPartData _gltfNode_30_r1 = head.addChild("_gltfNode_30_r1", ModelPartBuilder.create().uv(1270, 1154).cuboid(-12.505F, -0.185F, -20.825F, 25.0F, 46.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(-0.0836F, 93.1558F, -84.781F, 2.7925F, 0.0F, -3.1416F));

        ModelPartData _gltfNode_32_r1 = head.addChild("_gltfNode_32_r1", ModelPartBuilder.create().uv(1304, 682).cuboid(-8.67F, 4.64F, -16.66F, 17.0F, 62.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(-0.0836F, 129.7838F, -73.2523F, 2.1817F, 0.0F, -3.1416F));

        ModelPartData body = oliphaunt.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.7375F, -148.1128F, -6.1826F));

        ModelPartData _gltfNode_14_r1 = body.addChild("_gltfNode_14_r1", ModelPartBuilder.create().uv(920, 572).cuboid(-42.02F, 4.32F, -41.65F, 92.0F, 29.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(3.4275F, -63.7919F, 64.937F, -2.0508F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_12_r1 = body.addChild("_gltfNode_12_r1", ModelPartBuilder.create().uv(852, 147).cuboid(-46.185F, 33.4453F, -24.99F, 92.0F, 104.0F, 25.0F, new Dilation(0.0F)), ModelTransform.of(3.4275F, -64.1424F, 65.8724F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_16_r1 = body.addChild("_gltfNode_16_r1", ModelPartBuilder.create().uv(610, 635).cuboid(-37.515F, -4.04F, -45.815F, 75.0F, 104.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(-0.7375F, -72.6359F, -113.9506F, 3.0543F, 0.0F, -3.1416F));

        ModelPartData _gltfNode_0_r1 = body.addChild("_gltfNode_0_r1", ModelPartBuilder.create().uv(504, 420).cuboid(-53.855F, 8.4453F, 49.805F, 108.0F, 115.0F, 100.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-50.02F, 20.4453F, 0.0F, 100.0F, 117.0F, 140.0F, new Dilation(0.0F)), ModelTransform.of(-0.7375F, -66.6246F, 73.2038F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(-0.7375F, 37.5611F, 93.8428F));

        ModelPartData _gltfNode_102_r1 = tail.addChild("_gltfNode_102_r1", ModelPartBuilder.create().uv(1294, 412).cuboid(-16.67F, -45.505F, -12.495F, 25.0F, 58.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.7925F, 0.0F, -3.1416F));

        ModelPartData leg_front_right = oliphaunt.addChild("leg_front_right", ModelPartBuilder.create().uv(1086, 133).cuboid(-21.175F, 159.4571F, -26.0039F, 42.0F, 21.0F, 50.0F, new Dilation(0.0F))
                .uv(0, 984).cuboid(-16.34F, 63.5095F, -20.2884F, 33.0F, 96.0F, 46.0F, new Dilation(0.0F)), ModelTransform.pivot(-56.315F, -179.5058F, -71.0045F));

        ModelPartData _gltfNode_466_r1 = leg_front_right.addChild("_gltfNode_466_r1", ModelPartBuilder.create().uv(224, 862).cuboid(-20.335F, -16.8524F, -32.9626F, 42.0F, 96.0F, 58.0F, new Dilation(0.0F)), ModelTransform.of(-0.84F, -8.6195F, -0.5358F, 0.0873F, 0.0F, 0.0F));

        ModelPartData leg_front_left = oliphaunt.addChild("leg_front_left", ModelPartBuilder.create().uv(1082, 872).cuboid(-20.9534F, 159.0967F, -24.3298F, 42.0F, 21.0F, 50.0F, new Dilation(0.0F))
                .uv(874, 981).cuboid(-16.1181F, 63.1494F, -22.1141F, 33.0F, 96.0F, 46.0F, new Dilation(0.0F)), ModelTransform.pivot(56.7581F, -180.2263F, -71.1561F));

        ModelPartData _gltfNode_457_r1 = leg_front_left.addChild("_gltfNode_457_r1", ModelPartBuilder.create().uv(860, 635).cuboid(26.9847F, -16.8524F, -32.9626F, 42.0F, 96.0F, 58.0F, new Dilation(0.0F)), ModelTransform.of(-48.6031F, -7.899F, -0.3842F, 0.0873F, 0.0F, 0.0F));

        ModelPartData leg_back_left = oliphaunt.addChild("leg_back_left", ModelPartBuilder.create().uv(1086, 204).cuboid(-21.1767F, 129.1636F, -26.1669F, 42.0F, 17.0F, 50.0F, new Dilation(0.0F))
                .uv(326, 1156).cuboid(-16.342F, 95.8336F, -25.1259F, 33.0F, 42.0F, 42.0F, new Dilation(0.0F)), ModelTransform.pivot(47.1467F, -146.1633F, 52.9859F));

        ModelPartData _gltfNode_477_r1 = leg_back_left.addChild("_gltfNode_477_r1", ModelPartBuilder.create().uv(158, 1016).cuboid(-4.5117F, -45.6657F, -37.4886F, 42.0F, 54.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(-16.6617F, 100.3486F, 12.3591F, -0.3491F, 0.0F, 0.0F));

        ModelPartData _gltfNode_475_r1 = leg_back_left.addChild("_gltfNode_475_r1", ModelPartBuilder.create().uv(638, 789).cuboid(-8.3461F, -62.0031F, -58.315F, 50.0F, 87.0F, 62.0F, new Dilation(0.0F)), ModelTransform.of(-16.6617F, 33.7086F, 29.0191F, 0.0873F, 0.0F, 0.0F));

        ModelPartData leg_back_right = oliphaunt.addChild("leg_back_right", ModelPartBuilder.create().uv(1088, 271).cuboid(-21.1768F, 129.1637F, -26.1669F, 42.0F, 17.0F, 50.0F, new Dilation(0.0F))
                .uv(966, 1167).cuboid(-16.3418F, 95.8337F, -25.1259F, 33.0F, 42.0F, 42.0F, new Dilation(0.0F)), ModelTransform.pivot(-40.1432F, -146.1631F, 52.9859F));

        ModelPartData _gltfNode_489_r1 = leg_back_right.addChild("_gltfNode_489_r1", ModelPartBuilder.create().uv(1032, 981).cuboid(-4.5117F, -45.6657F, -37.4886F, 42.0F, 54.0F, 46.0F, new Dilation(0.0F)), ModelTransform.of(-16.6618F, 100.3487F, 12.3591F, -0.3491F, 0.0F, 0.0F));

        ModelPartData _gltfNode_487_r1 = leg_back_right.addChild("_gltfNode_487_r1", ModelPartBuilder.create().uv(0, 835).cuboid(-8.3461F, -62.0031F, -58.315F, 50.0F, 87.0F, 62.0F, new Dilation(0.0F)), ModelTransform.of(-16.6618F, 33.7084F, 29.0191F, 0.0873F, 0.0F, 0.0F));

        ModelPartData howdah = oliphaunt.addChild("howdah", ModelPartBuilder.create(), ModelTransform.pivot(-30.7898F, -211.7157F, -7.0642F));

        ModelPartData level3 = howdah.addChild("level3", ModelPartBuilder.create().uv(480, 207).cuboid(64.475F, -24.05F, -209.2087F, 13.0F, 44.0F, 0.0F, new Dilation(0.0F))
                .uv(132, 1126).cuboid(162.225F, -24.05F, -209.2087F, 13.0F, 44.0F, 0.0F, new Dilation(0.0F))
                .uv(1210, 98).cuboid(79.6332F, -118.3165F, 30.4829F, 80.0F, 26.0F, 0.0F, new Dilation(0.0F))
                .uv(518, 335).cuboid(71.5758F, -96.025F, -44.9588F, 97.0F, 7.0F, 78.0F, new Dilation(0.0F))
                .uv(506, 1096).cuboid(166.2832F, -122.3165F, -42.6674F, 0.0F, 30.0F, 73.0F, new Dilation(0.0F))
                .uv(690, 1379).cuboid(159.0758F, -98.6914F, -46.4596F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(852, 324).cuboid(72.475F, -130.875F, 27.1912F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(902, 408).cuboid(72.475F, -130.875F, -43.225F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(818, 1110).cuboid(162.25F, -130.875F, -43.225F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(1216, 537).cuboid(79.6332F, -118.3165F, -43.2583F, 80.0F, 26.0F, 0.0F, new Dilation(0.0F))
                .uv(1380, 75).cuboid(159.0758F, -120.2415F, -46.4596F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(1380, 699).cuboid(69.3008F, -120.2415F, 23.3654F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(1380, 720).cuboid(159.0758F, -120.2415F, 23.3654F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(1380, 741).cuboid(159.0758F, -98.6914F, 23.3654F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(652, 1096).cuboid(73.1832F, -122.3165F, -42.6674F, 0.0F, 30.0F, 73.0F, new Dilation(0.0F))
                .uv(488, 623).cuboid(162.25F, -130.875F, 27.1912F, 4.0F, 7.0F, 4.0F, new Dilation(0.0F))
                .uv(1380, 678).cuboid(69.3008F, -120.2415F, -46.4596F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(734, 1379).cuboid(69.3008F, -98.6914F, -46.4596F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F))
                .uv(1384, 244).cuboid(69.3008F, -98.6914F, 23.3654F, 11.0F, 10.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(-88.9549F, -62.4653F, 1.8812F));

        ModelPartData _gltfNode_336_r1 = level3.addChild("_gltfNode_336_r1", ModelPartBuilder.create().uv(644, 981).cuboid(-2.0F, -2.0F, 3.0F, 4.0F, 4.0F, 111.0F, new Dilation(0.0F))
                .uv(966, 0).cuboid(87.0111F, -2.0F, 3.0F, 4.0F, 4.0F, 111.0F, new Dilation(0.0F)), ModelTransform.of(75.2391F, -22.5929F, -210.8697F, 0.3927F, 0.0F, 0.0F));

        ModelPartData _gltfNode_358_r1 = level3.addChild("_gltfNode_358_r1", ModelPartBuilder.create().uv(1032, 1081).cuboid(-2.0F, -2.0F, -80.5F, 4.0F, 4.0F, 82.0F, new Dilation(0.0F))
                .uv(334, 1070).cuboid(87.0106F, -2.0F, -80.5F, 4.0F, 4.0F, 82.0F, new Dilation(0.0F)), ModelTransform.of(75.2394F, -117.467F, -44.8174F, 0.6981F, 0.0F, 0.0F));

        ModelPartData _gltfNode_338_r1 = level3.addChild("_gltfNode_338_r1", ModelPartBuilder.create().uv(920, 548).cuboid(-0.0627F, -6.0273F, -0.8406F, 144.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0894F, 0.0F, 0.0F, -0.0012F, -0.1994F, -0.9928F));

        ModelPartData _gltfNode_354_r1 = level3.addChild("_gltfNode_354_r1", ModelPartBuilder.create().uv(920, 564).cuboid(-3.1174F, -4.7161F, -0.9141F, 139.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0894F, -3.325F, -46.55F, 0.0215F, -0.0355F, -0.9916F));

        ModelPartData _gltfNode_353_r1 = level3.addChild("_gltfNode_353_r1", ModelPartBuilder.create().uv(920, 556).cuboid(-135.8826F, -4.7161F, -0.9141F, 139.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(239.4F, -3.325F, -46.55F, 0.0215F, 0.0355F, 0.9916F));

        ModelPartData _gltfNode_337_r1 = level3.addChild("_gltfNode_337_r1", ModelPartBuilder.create().uv(920, 540).cuboid(-143.9373F, -6.0273F, -0.8406F, 144.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(239.4F, 0.0F, 0.0F, -0.0012F, 0.1994F, 0.9928F));

        ModelPartData _gltfNode_325_r1 = level3.addChild("_gltfNode_325_r1", ModelPartBuilder.create().uv(1378, 426).cuboid(5.7788F, -93.5852F, -2.7741F, 14.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(89.775F, 16.625F, -125.7587F, 1.1821F, 0.3711F, 0.0018F));

        ModelPartData _gltfNode_323_r1 = level3.addChild("_gltfNode_323_r1", ModelPartBuilder.create().uv(640, 1372).cuboid(-19.8138F, -93.5852F, -2.7741F, 14.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(149.625F, 16.625F, -125.7587F, 1.1821F, -0.3711F, -0.0018F));

        ModelPartData columns2 = level3.addChild("columns2", ModelPartBuilder.create().uv(304, 1305).cuboid(39.8758F, -170.3904F, -3.3258F, 10.0F, 98.0F, 10.0F, new Dilation(0.0F))
                .uv(264, 1305).cuboid(-49.8992F, -170.3904F, -3.3258F, 10.0F, 98.0F, 10.0F, new Dilation(0.0F))
                .uv(858, 1273).cuboid(-49.8992F, -170.3904F, -73.1508F, 10.0F, 98.0F, 10.0F, new Dilation(0.0F))
                .uv(568, 1272).cuboid(39.8758F, -170.3904F, -73.1508F, 10.0F, 98.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(119.7F, 46.55F, 27.1912F));

        ModelPartData level2 = howdah.addChild("level2", ModelPartBuilder.create().uv(132, 1196).cuboid(-56.55F, -80.725F, 3.325F, 10.0F, 10.0F, 63.0F, new Dilation(0.0F))
                .uv(1204, 1131).cuboid(-40.0937F, -80.3989F, 66.4994F, 80.0F, 13.0F, 10.0F, new Dilation(0.0F))
                .uv(644, 938).cuboid(-43.0934F, -90.6995F, 69.8244F, 83.0F, 10.0F, 10.0F, new Dilation(0.0F))
                .uv(326, 789).cuboid(-46.45F, -77.4F, 3.325F, 93.0F, 10.0F, 63.0F, new Dilation(0.0F))
                .uv(476, 1199).cuboid(46.525F, -80.725F, 3.325F, 10.0F, 10.0F, 63.0F, new Dilation(0.0F))
                .uv(1208, 1043).cuboid(-40.0937F, -80.3989F, -3.3258F, 80.0F, 13.0F, 10.0F, new Dilation(0.0F))
                .uv(644, 958).cuboid(-43.0934F, -90.6995F, -6.6508F, 83.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(30.7451F, -15.9152F, -40.7527F));

        ModelPartData _gltfNode_273_r1 = level2.addChild("_gltfNode_273_r1", ModelPartBuilder.create().uv(198, 1327).cuboid(-6.6745F, -59.6756F, 0.0F, 10.0F, 53.0F, 7.0F, new Dilation(0.0F))
                .uv(1324, 487).cuboid(-4.0668F, -51.6168F, 3.2917F, 44.0F, 45.0F, 0.0F, new Dilation(0.0F))
                .uv(798, 1110).cuboid(-6.6745F, -72.8757F, 3.325F, 10.0F, 13.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-53.2F, -67.4001F, 36.575F, 1.2835F, 1.4352F, 0.4618F));

        ModelPartData _gltfNode_171_r1 = level2.addChild("_gltfNode_171_r1", ModelPartBuilder.create().uv(480, 147).cuboid(-3.3757F, -59.6756F, 0.0F, 10.0F, 53.0F, 7.0F, new Dilation(0.0F))
                .uv(110, 1327).cuboid(-40.6417F, -51.6168F, 3.2917F, 44.0F, 45.0F, 0.0F, new Dilation(0.0F))
                .uv(1060, 133).cuboid(-3.3757F, -72.8757F, 3.325F, 10.0F, 13.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(53.2F, -67.4001F, 36.575F, 1.2835F, -1.4352F, -0.4618F));

        ModelPartData _gltfNode_387_r1 = level2.addChild("_gltfNode_387_r1", ModelPartBuilder.create().uv(110, 1372).cuboid(-0.3757F, -59.6756F, -6.65F, 7.0F, 53.0F, 7.0F, new Dilation(0.0F))
                .uv(624, 892).cuboid(99.4005F, -69.8495F, -3.325F, 7.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(624, 882).cuboid(-0.3495F, -69.8495F, -3.325F, 7.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(1154, 572).cuboid(6.7835F, -51.6168F, -3.3582F, 93.0F, 45.0F, 0.0F, new Dilation(0.0F))
                .uv(1368, 1347).cuboid(99.3743F, -59.6756F, -6.65F, 7.0F, 53.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-53.2F, -60.7501F, 72.5588F, -0.6109F, 0.0F, 0.0F));

        ModelPartData _gltfNode_377_r1 = level2.addChild("_gltfNode_377_r1", ModelPartBuilder.create().uv(1154, 784).cuboid(6.7835F, -51.6168F, 3.2918F, 93.0F, 45.0F, 0.0F, new Dilation(0.0F))
                .uv(624, 872).cuboid(-0.3757F, -69.8757F, 3.325F, 7.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(624, 862).cuboid(99.3743F, -69.8757F, 3.325F, 7.0F, 10.0F, 0.0F, new Dilation(0.0F))
                .uv(384, 1365).cuboid(99.3743F, -59.6756F, 0.0F, 7.0F, 53.0F, 7.0F, new Dilation(0.0F))
                .uv(384, 1305).cuboid(-0.3757F, -59.6756F, 0.0F, 7.0F, 53.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-53.2F, -60.7501F, 0.0F, 0.6109F, 0.0F, 0.0F));

        ModelPartData _gltfNode_375_r1 = level2.addChild("_gltfNode_375_r1", ModelPartBuilder.create().uv(608, 1327).cuboid(-40.6417F, -51.6168F, -3.3583F, 44.0F, 45.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(53.2F, -67.4001F, 29.3338F, -1.2835F, 1.4352F, -0.4618F));

        ModelPartData _gltfNode_373_r1 = level2.addChild("_gltfNode_373_r1", ModelPartBuilder.create().uv(1314, 829).cuboid(-6.7417F, -33.526F, 9.9918F, 50.0F, 36.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(49.875F, -84.0251F, 69.2338F, -0.7405F, 0.5545F, -0.4486F));

        ModelPartData _gltfNode_369_r1 = level2.addChild("_gltfNode_369_r1", ModelPartBuilder.create().uv(1298, 1311).cuboid(-6.7417F, -33.526F, -10.0583F, 50.0F, 36.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(49.875F, -84.0251F, 0.0F, 0.7405F, -0.5545F, -0.4486F));

        ModelPartData _gltfNode_363_r1 = level2.addChild("_gltfNode_363_r1", ModelPartBuilder.create().uv(1198, 1311).cuboid(-43.3167F, -33.526F, -10.0583F, 50.0F, 36.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-49.875F, -84.0251F, 0.0F, 0.7405F, 0.5545F, 0.4486F));

        ModelPartData _gltfNode_271_r1 = level2.addChild("_gltfNode_271_r1", ModelPartBuilder.create().uv(334, 1016).cuboid(-4.0668F, -51.6168F, -3.3583F, 44.0F, 45.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-53.2F, -67.4001F, 29.3338F, -1.2835F, -1.4352F, 0.4618F));

        ModelPartData _gltfNode_269_r1 = level2.addChild("_gltfNode_269_r1", ModelPartBuilder.create().uv(1082, 943).cuboid(-43.3167F, -33.526F, 9.9918F, 50.0F, 36.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-49.875F, -84.0251F, 69.2338F, -0.7405F, -0.5545F, 0.4486F));

        ModelPartData columns = level2.addChild("columns", ModelPartBuilder.create().uv(1384, 1271).cuboid(-57.0492F, -77.4095F, -6.5596F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(344, 1305).cuboid(-56.5492F, -114.2161F, -6.0596F, 10.0F, 71.0F, 10.0F, new Dilation(0.0F))
                .uv(1390, 128).cuboid(-57.0492F, -104.0095F, -6.5596F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(1390, 112).cuboid(-57.0492F, -110.6595F, -6.5596F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(818, 1329).cuboid(46.5255F, -114.2161F, -6.0596F, 10.0F, 71.0F, 10.0F, new Dilation(0.0F))
                .uv(1384, 1287).cuboid(46.0255F, -77.4095F, -6.5596F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(1384, 1255).cuboid(46.0255F, -104.0095F, -6.5596F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(1384, 1239).cuboid(46.0255F, -110.6595F, -6.5596F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(778, 1329).cuboid(46.5255F, -114.2161F, -79.2096F, 10.0F, 71.0F, 10.0F, new Dilation(0.0F))
                .uv(172, 1387).cuboid(46.0255F, -77.4095F, -79.7096F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(1292, 765).cuboid(46.0255F, -104.0095F, -79.7096F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(1286, 1388).cuboid(46.0255F, -110.6595F, -79.7096F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(898, 1353).cuboid(-56.5492F, -114.2161F, -79.2096F, 10.0F, 71.0F, 10.0F, new Dilation(0.0F))
                .uv(278, 1224).cuboid(-57.0492F, -110.6595F, -79.7096F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(1388, 1041).cuboid(-57.0492F, -104.0095F, -79.7096F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F))
                .uv(0, 1388).cuboid(-57.0492F, -77.4095F, -79.7096F, 11.0F, 5.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 36.575F, 72.5588F));

        ModelPartData level1 = howdah.addChild("level1", ModelPartBuilder.create().uv(1082, 849).cuboid(-49.4665F, -13.0251F, -56.526F, 106.0F, 13.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(27.4201F, -19.2402F, 62.3226F));

        ModelPartData _gltfNode_439_r1 = level1.addChild("_gltfNode_439_r1", ModelPartBuilder.create().uv(920, 626).cuboid(2.8268F, 12.4028F, -3.3255F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(123.025F, -63.1751F, -106.4002F, 3.1416F, 0.0436F, 2.0508F));

        ModelPartData _gltfNode_431_r1 = level1.addChild("_gltfNode_431_r1", ModelPartBuilder.create().uv(1272, 300).cuboid(10.5614F, -23.8704F, -6.6508F, 0.0F, 13.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-89.525F, -31.0F, -106.4002F, 0.0F, 0.0F, -0.3927F));

        ModelPartData _gltfNode_429_r1 = level1.addChild("_gltfNode_429_r1", ModelPartBuilder.create().uv(110, 1238).cuboid(10.5614F, -23.8704F, -6.6508F, 0.0F, 13.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-86.45F, -33.25F, -19.95F, 0.0F, 0.0F, -0.3927F));

        ModelPartData _gltfNode_409_r1 = level1.addChild("_gltfNode_409_r1", ModelPartBuilder.create().uv(868, 408).cuboid(-42.318F, -2.9504F, -3.325F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-96.425F, -19.95F, -9.975F, 0.0F, 0.0F, 1.0908F));

        ModelPartData _gltfNode_407_r1 = level1.addChild("_gltfNode_407_r1", ModelPartBuilder.create().uv(292, 849).cuboid(2.8268F, 12.4028F, -3.3255F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(123.025F, -63.1751F, -59.8502F, 3.1416F, 0.0436F, 2.0508F));

        ModelPartData _gltfNode_405_r1 = level1.addChild("_gltfNode_405_r1", ModelPartBuilder.create().uv(1182, 943).cuboid(-9.5615F, -23.8704F, -6.6508F, 0.0F, 13.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(93.1F, -33.25F, -19.95F, 0.0F, 0.0F, 0.3927F));

        ModelPartData _gltfNode_349_r1 = level1.addChild("_gltfNode_349_r1", ModelPartBuilder.create().uv(258, 849).cuboid(32.293F, -2.9504F, -3.325F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(103.075F, -19.95F, -9.975F, 0.0F, 0.0F, -1.0908F));

        ModelPartData _gltfNode_321_r1 = level1.addChild("_gltfNode_321_r1", ModelPartBuilder.create().uv(132, 1170).cuboid(-10.0615F, -20.8704F, -6.6508F, 0.0F, 13.0F, 10.0F, new Dilation(0.0F))
                .uv(1384, 1122).cuboid(-16.5615F, -10.2704F, 79.7994F, 7.0F, 18.0F, 10.0F, new Dilation(0.0F))
                .uv(568, 1380).cuboid(-13.7365F, -8.2715F, -6.65F, 7.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(96.425F, -33.25F, -106.4002F, 0.0F, 0.0F, 0.3927F));

        ModelPartData _gltfNode_313_r1 = level1.addChild("_gltfNode_313_r1", ModelPartBuilder.create().uv(614, 1070).cuboid(-9.675F, -40.9039F, 5.5894F, 13.0F, 17.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(6.65F, -39.9F, -163.5166F, 0.2182F, 0.0F, 0.0F));

        ModelPartData _gltfNode_435_r1 = level1.addChild("_gltfNode_435_r1", ModelPartBuilder.create().uv(414, 623).cuboid(3.1256F, 12.4028F, -3.3255F, 13.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(126.35F, -63.1751F, -59.8502F, 3.1416F, 0.0436F, 2.0508F));

        ModelPartData _gltfNode_427_r1 = level1.addChild("_gltfNode_427_r1", ModelPartBuilder.create().uv(1208, 1066).cuboid(-3.764F, -4.5365F, -3.3255F, 73.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(59.85F, 19.95F, -9.975F, 0.0F, 0.0F, -0.829F));

        ModelPartData _gltfNode_445_r1 = level1.addChild("_gltfNode_445_r1", ModelPartBuilder.create().uv(224, 849).cuboid(-12.824F, 12.4028F, -3.3255F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-116.375F, -63.1751F, -106.4002F, 3.1416F, -0.0436F, -2.0508F));

        ModelPartData _gltfNode_443_r1 = level1.addChild("_gltfNode_443_r1", ModelPartBuilder.create().uv(374, 623).cuboid(-15.824F, 12.4028F, -3.3255F, 13.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-119.7F, -63.1751F, -59.8502F, 3.1416F, -0.0436F, -2.0508F));

        ModelPartData _gltfNode_441_r1 = level1.addChild("_gltfNode_441_r1", ModelPartBuilder.create().uv(454, 623).cuboid(-12.824F, 12.4028F, -3.3255F, 10.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-116.375F, -63.1751F, -59.8502F, 3.1416F, -0.0436F, -2.0508F));

        ModelPartData _gltfNode_437_r1 = level1.addChild("_gltfNode_437_r1", ModelPartBuilder.create().uv(334, 623).cuboid(-15.824F, 12.4028F, -3.3255F, 13.0F, 0.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-119.7F, -63.1751F, -106.4002F, 3.1416F, -0.0436F, -2.0508F));

        ModelPartData _gltfNode_413_r1 = level1.addChild("_gltfNode_413_r1", ModelPartBuilder.create().uv(1208, 993).cuboid(-10.0146F, -0.2416F, 0.0F, 29.0F, 0.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(-116.375F, -33.4193F, -56.5252F, 0.3011F, 0.0618F, 1.0501F));

        ModelPartData _gltfNode_411_r1 = level1.addChild("_gltfNode_411_r1", ModelPartBuilder.create().uv(1154, 829).cuboid(-69.0743F, -4.5365F, -3.3255F, 73.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-53.2F, 19.95F, -9.975F, 0.0F, 0.0F, 0.829F));

        ModelPartData _gltfNode_385_r1 = level1.addChild("_gltfNode_385_r1", ModelPartBuilder.create().uv(424, 938).cuboid(-8.7106F, 3.1821F, -103.1085F, 0.0F, 22.0F, 110.0F, new Dilation(0.0F)), ModelTransform.of(-79.8F, -43.55F, -99.7502F, 0.3853F, -0.9883F, -0.4893F));

        ModelPartData _gltfNode_383_r1 = level1.addChild("_gltfNode_383_r1", ModelPartBuilder.create().uv(920, 408).cuboid(-2.0028F, 3.2075F, -60.7943F, 0.0F, 22.0F, 110.0F, new Dilation(0.0F)), ModelTransform.of(43.225F, -43.55F, 9.3834F, -0.5521F, -0.9289F, 0.6927F));

        ModelPartData _gltfNode_381_r1 = level1.addChild("_gltfNode_381_r1", ModelPartBuilder.create().uv(1140, 427).cuboid(0.379F, -9.0805F, 26.5667F, 0.0F, 12.0F, 77.0F, new Dilation(0.0F)), ModelTransform.of(-79.8F, -30.25F, -129.6753F, 0.0F, 0.0436F, -0.3927F));

        ModelPartData _gltfNode_379_r1 = level1.addChild("_gltfNode_379_r1", ModelPartBuilder.create().uv(868, 276).cuboid(8.7771F, 3.1821F, -103.1085F, 0.0F, 22.0F, 110.0F, new Dilation(0.0F)), ModelTransform.of(86.45F, -43.55F, -99.7502F, 0.3853F, 0.9883F, 0.4893F));

        ModelPartData _gltfNode_347_r1 = level1.addChild("_gltfNode_347_r1", ModelPartBuilder.create().uv(1370, 1154).cuboid(2.318F, -6.6254F, -3.325F, 30.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(1208, 943).cuboid(2.3512F, -2.9171F, -3.3582F, 30.0F, 0.0F, 50.0F, new Dilation(0.0F))
                .uv(1370, 98).cuboid(2.3512F, -6.5921F, 43.1917F, 30.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(116.375F, -16.625F, -106.4002F, 0.0F, 0.0F, -1.0908F));

        ModelPartData _gltfNode_341_r1 = level1.addChild("_gltfNode_341_r1", ModelPartBuilder.create().uv(1204, 1081).cuboid(-10.9481F, 0.3081F, -0.0665F, 30.0F, 0.0F, 50.0F, new Dilation(0.0F)), ModelTransform.of(119.7F, -29.925F, -56.5252F, 0.2608F, 0.0226F, -1.1751F));

        ModelPartData _gltfNode_339_r1 = level1.addChild("_gltfNode_339_r1", ModelPartBuilder.create().uv(1378, 412).cuboid(1.2846F, -5.1622F, -3.325F, 23.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(106.4F, -29.925F, -9.975F, 0.0F, 0.0F, -1.1781F));

        ModelPartData _gltfNode_319_r1 = level1.addChild("_gltfNode_319_r1", ModelPartBuilder.create().uv(334, 573).cuboid(-32.3597F, -2.9171F, -3.3582F, 30.0F, 0.0F, 50.0F, new Dilation(0.0F))
                .uv(1368, 1066).cuboid(-32.3906F, -6.6248F, 43.2245F, 30.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(798, 1096).cuboid(-32.3906F, -6.6248F, -3.3255F, 30.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-109.725F, -16.625F, -106.4002F, 0.0F, 0.0F, 1.0908F));

        ModelPartData _gltfNode_253_r1 = level1.addChild("_gltfNode_253_r1", ModelPartBuilder.create().uv(1376, 546).cuboid(-24.0096F, -5.1622F, -3.325F, 23.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-99.75F, -29.925F, -9.975F, 0.0F, 0.0F, 1.1781F));

        ModelPartData _gltfNode_241_r1 = level1.addChild("_gltfNode_241_r1", ModelPartBuilder.create().uv(1140, 338).cuboid(-0.3125F, -9.0805F, 26.5667F, 0.0F, 12.0F, 77.0F, new Dilation(0.0F)), ModelTransform.of(86.45F, -30.25F, -129.6753F, 0.0F, -0.0436F, 0.3927F));

        ModelPartData _gltfNode_239_r1 = level1.addChild("_gltfNode_239_r1", ModelPartBuilder.create().uv(1372, 613).cuboid(-10.3245F, -45.3245F, -6.65F, 7.0F, 42.0F, 9.0F, new Dilation(0.0F))
                .uv(1370, 1168).cuboid(-7.0257F, -45.3245F, -93.1002F, 7.0F, 42.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(53.2F, 3.325F, -19.95F, 0.0F, 0.0F, 0.829F));

        ModelPartData _gltfNode_235_r1 = level1.addChild("_gltfNode_235_r1", ModelPartBuilder.create().uv(862, 849).cuboid(2.0693F, 3.2075F, -60.7943F, 0.0F, 22.0F, 110.0F, new Dilation(0.0F)), ModelTransform.of(-36.575F, -43.55F, 9.3834F, -0.5521F, 0.9289F, -0.6927F));

        ModelPartData _gltfNode_233_r1 = level1.addChild("_gltfNode_233_r1", ModelPartBuilder.create().uv(1088, 338).cuboid(-3.025F, -60.0F, -3.325F, 13.0F, 60.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -9.975F, -139.65F, 0.4363F, 0.0F, 0.0F));

        ModelPartData _gltfNode_215_r1 = level1.addChild("_gltfNode_215_r1", ModelPartBuilder.create().uv(1384, 265).cuboid(9.7115F, -10.2704F, -6.6508F, 7.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-89.775F, -33.25F, -19.95F, 0.0F, 0.0F, -0.3927F));

        ModelPartData _gltfNode_213_r1 = level1.addChild("_gltfNode_213_r1", ModelPartBuilder.create().uv(608, 1372).cuboid(2.9755F, -45.3245F, -6.65F, 7.0F, 42.0F, 9.0F, new Dilation(0.0F))
                .uv(138, 1372).cuboid(-0.3757F, -45.3245F, -93.1002F, 7.0F, 42.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-46.55F, 3.325F, -19.95F, 0.0F, 0.0F, -0.829F));

        ModelPartData _gltfNode_211_r1 = level1.addChild("_gltfNode_211_r1", ModelPartBuilder.create().uv(858, 1381).cuboid(-3.5F, -9.0F, -5.0F, 7.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-80.6277F, -36.9581F, -108.0502F, 0.0F, 0.0F, -0.3927F));

        ModelPartData _gltfNode_205_r1 = level1.addChild("_gltfNode_205_r1", ModelPartBuilder.create().uv(1364, 1094).cuboid(-29.6745F, -3.6745F, -3.325F, 33.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(1364, 1080).cuboid(-29.6745F, -3.6745F, -49.875F, 33.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-49.875F, 43.225F, -59.8502F, 0.0F, 0.0F, 0.6545F));

        ModelPartData _gltfNode_203_r1 = level1.addChild("_gltfNode_203_r1", ModelPartBuilder.create().uv(1376, 532).cuboid(-22.6993F, -6.678F, -3.3255F, 24.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(1372, 664).cuboid(-22.6993F, -6.678F, -49.8755F, 24.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-76.475F, 26.6F, -59.8502F, 0.0F, 0.0F, 1.1345F));

        ModelPartData _gltfNode_201_r1 = level1.addChild("_gltfNode_201_r1", ModelPartBuilder.create().uv(1340, 809).cuboid(-37.7567F, -4.2737F, -3.3255F, 40.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(1270, 1225).cuboid(-37.7567F, -4.2737F, -49.8755F, 40.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-83.125F, 6.65F, -59.8502F, 0.0F, 0.0F, 0.7854F));

        ModelPartData _gltfNode_177_r1 = level1.addChild("_gltfNode_177_r1", ModelPartBuilder.create().uv(966, 133).cuboid(-2.3369F, -4.2737F, -3.3255F, 40.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(224, 835).cuboid(-2.3369F, -4.2737F, -49.8755F, 40.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(89.775F, 6.65F, -59.8502F, 0.0F, 0.0F, -0.7854F));

        ModelPartData _gltfNode_175_r1 = level1.addChild("_gltfNode_175_r1", ModelPartBuilder.create().uv(1234, 696).cuboid(-2.022F, -6.678F, -3.3255F, 24.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(1234, 682).cuboid(-2.022F, -6.678F, -49.8755F, 24.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(83.125F, 26.6F, -59.8502F, 0.0F, 0.0F, -1.1345F));

        ModelPartData _gltfNode_173_r1 = level1.addChild("_gltfNode_173_r1", ModelPartBuilder.create().uv(1364, 1225).cuboid(-3.0745F, -3.6745F, -3.325F, 33.0F, 7.0F, 7.0F, new Dilation(0.0F))
                .uv(1364, 1108).cuboid(-3.0745F, -3.6745F, -49.875F, 33.0F, 7.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(56.525F, 43.225F, -59.8502F, 0.0F, 0.0F, -0.6545F));

        ModelPartData _gltfNode_137_r1 = level1.addChild("_gltfNode_137_r1", ModelPartBuilder.create().uv(278, 1196).cuboid(-3.025F, -4.3039F, -14.7394F, 13.0F, 18.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -39.9F, 33.25F, -0.2182F, 0.0F, 0.0F));

        ModelPartData _gltfNode_111_r1 = level1.addChild("_gltfNode_111_r1", ModelPartBuilder.create().uv(1366, 993).cuboid(-3.025F, -38.0F, -6.65F, 13.0F, 38.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData harness = howdah.addChild("harness", ModelPartBuilder.create().uv(966, 115).cuboid(-55.6779F, 154.7682F, -32.9205F, 111.0F, 7.0F, 11.0F, new Dilation(0.0F))
                .uv(1060, 721).cuboid(-55.4997F, 143.4459F, -134.1661F, 111.0F, 7.0F, 11.0F, new Dilation(0.0F))
                .uv(1076, 1251).cuboid(54.8131F, 18.7682F, -85.2895F, 4.0F, 138.0F, 11.0F, new Dilation(0.0F))
                .uv(902, 1203).cuboid(41.8306F, -11.2318F, -179.553F, 7.0F, 132.0F, 18.0F, new Dilation(0.0F))
                .uv(0, 1238).cuboid(-48.9417F, -11.2318F, -179.553F, 7.0F, 132.0F, 18.0F, new Dilation(0.0F))
                .uv(234, 1269).cuboid(-59.4154F, 18.7682F, -85.2895F, 4.0F, 138.0F, 11.0F, new Dilation(0.0F))
                .uv(50, 1238).cuboid(-59.4157F, 1.2414F, -134.1661F, 4.0F, 149.0F, 11.0F, new Dilation(0.0F))
                .uv(416, 1240).cuboid(54.8131F, 18.7682F, -32.9205F, 4.0F, 143.0F, 11.0F, new Dilation(0.0F))
                .uv(446, 1240).cuboid(-59.4154F, 18.7682F, -32.9205F, 4.0F, 143.0F, 11.0F, new Dilation(0.0F))
                .uv(80, 1238).cuboid(54.8131F, 1.2414F, -134.1661F, 4.0F, 149.0F, 11.0F, new Dilation(0.0F))
                .uv(1060, 739).cuboid(-55.6779F, 149.7682F, -85.2895F, 111.0F, 7.0F, 11.0F, new Dilation(0.0F))
                .uv(1106, 1357).cuboid(-53.2697F, 22.7391F, -157.8766F, 10.0F, 7.0F, 27.0F, new Dilation(0.0F))
                .uv(0, 761).cuboid(-52.8362F, 12.7405F, -121.3047F, 106.0F, 17.0F, 57.0F, new Dilation(0.0F))
                .uv(1350, 41).cuboid(43.1553F, 22.7391F, -157.8766F, 10.0F, 7.0F, 27.0F, new Dilation(0.0F))
                .uv(696, 1329).cuboid(49.1553F, 30.0397F, -121.3044F, 4.0F, 13.0F, 37.0F, new Dilation(0.0F))
                .uv(1340, 765).cuboid(49.4803F, 42.6897F, -121.3044F, 7.0F, 7.0F, 37.0F, new Dilation(0.0F))
                .uv(1340, 563).cuboid(-53.9194F, 30.0397F, -121.3044F, 4.0F, 13.0F, 37.0F, new Dilation(0.0F))
                .uv(1198, 1347).cuboid(-56.9194F, 42.6897F, -121.3044F, 7.0F, 7.0F, 37.0F, new Dilation(0.0F))
                .uv(862, 789).cuboid(-52.8362F, 13.0655F, -64.7534F, 106.0F, 20.0F, 40.0F, new Dilation(0.0F))
                .uv(480, 0).cuboid(-50.1697F, 2.4641F, -161.2016F, 100.0F, 4.0F, 143.0F, new Dilation(0.0F))
                .uv(0, 420).cuboid(-52.8447F, 6.1141F, -161.2016F, 106.0F, 7.0F, 146.0F, new Dilation(0.0F))
                .uv(1060, 757).cuboid(-52.8362F, 12.7402F, -24.8771F, 106.0F, 17.0F, 10.0F, new Dilation(0.0F))
                .uv(0, 257).cuboid(-56.4862F, -13.8277F, -161.2348F, 113.0F, 17.0F, 146.0F, new Dilation(0.0F)), ModelTransform.pivot(30.7898F, -22.3793F, 80.5489F));

        ModelPartData _gltfNode_8_r1 = harness.addChild("_gltfNode_8_r1", ModelPartBuilder.create().uv(0, 573).cuboid(-45.8147F, 137.2717F, -16.6601F, 0.0F, 21.0F, 167.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 15.9408F, -7.221F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_6_r1 = harness.addChild("_gltfNode_6_r1", ModelPartBuilder.create().uv(518, 147).cuboid(41.65F, 137.27F, -16.66F, 0.0F, 21.0F, 167.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 12.5237F, -7.9785F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_4_r1 = harness.addChild("_gltfNode_4_r1", ModelPartBuilder.create().uv(1196, 77).cuboid(-50.35F, 139.3465F, -17.4781F, 92.0F, 21.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 19.3576F, -6.4635F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData _gltfNode_2_r1 = harness.addChild("_gltfNode_2_r1", ModelPartBuilder.create().uv(1140, 516).cuboid(-46.1849F, 137.2718F, 149.9412F, 92.0F, 21.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -3.0543F, 0.0F, 3.1416F));

        ModelPartData front = harness.addChild("front", ModelPartBuilder.create(), ModelTransform.pivot(39.8553F, -13.4859F, -191.1263F));

        ModelPartData _gltfNode_257_r1 = front.addChild("_gltfNode_257_r1", ModelPartBuilder.create().uv(1368, 930).cuboid(-1.3317F, -43.426F, -6.1407F, 10.0F, 50.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-36.575F, -9.975F, -13.3F, 1.1586F, -0.4916F, 0.0544F));

        ModelPartData _gltfNode_207_r1 = front.addChild("_gltfNode_207_r1", ModelPartBuilder.create().uv(830, 938).cuboid(-0.3495F, -27.4177F, -2.5568F, 7.0F, 30.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-86.45F, 23.275F, 16.625F, 0.5564F, -0.1166F, 0.1848F));

        ModelPartData _gltfNode_217_r1 = front.addChild("_gltfNode_217_r1", ModelPartBuilder.create().uv(1294, 487).cuboid(-0.6603F, -18.0202F, -1.0405F, 7.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-79.8F, 0.0F, 0.0F, 0.3298F, -0.4703F, 0.9239F));

        ModelPartData _gltfNode_179_r1 = front.addChild("_gltfNode_179_r1", ModelPartBuilder.create().uv(938, 1355).cuboid(-6.3489F, -52.9958F, -3.3258F, 13.0F, 53.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-69.825F, 16.625F, 33.25F, 1.0305F, -0.1582F, 0.2095F));

        ModelPartData _gltfNode_255_r1 = front.addChild("_gltfNode_255_r1", ModelPartBuilder.create().uv(1030, 1355).cuboid(-8.6933F, -43.426F, -6.1407F, 10.0F, 50.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-43.225F, -9.975F, -13.3F, 1.1586F, 0.4916F, -0.0544F));

        ModelPartData _gltfNode_327_r1 = front.addChild("_gltfNode_327_r1", ModelPartBuilder.create().uv(1378, 445).cuboid(6.0288F, -42.0604F, -3.5241F, 14.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-69.825F, -10.475F, -13.3F, 1.1821F, 0.3711F, 0.0018F));

        ModelPartData _gltfNode_183_r1 = front.addChild("_gltfNode_183_r1", ModelPartBuilder.create().uv(476, 1272).cuboid(6.4795F, -101.4847F, -2.4748F, 13.0F, 117.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-69.825F, -9.975F, -13.3F, 1.1821F, 0.3711F, 0.0018F));

        ModelPartData _gltfNode_329_r1 = front.addChild("_gltfNode_329_r1", ModelPartBuilder.create().uv(1378, 464).cuboid(-19.5638F, -42.0604F, -3.2741F, 14.0F, 8.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(-9.975F, -10.475F, -13.3F, 1.1821F, -0.3711F, -0.0018F));

        ModelPartData _gltfNode_165_r1 = front.addChild("_gltfNode_165_r1", ModelPartBuilder.create().uv(506, 1070).cuboid(-17.4F, -46.575F, -23.275F, 44.0F, 10.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-43.225F, 16.625F, 33.25F, 0.5654F, 0.0531F, -0.0693F));

        ModelPartData _gltfNode_181_r1 = front.addChild("_gltfNode_181_r1", ModelPartBuilder.create().uv(984, 1355).cuboid(-6.3489F, -52.9958F, -3.3258F, 13.0F, 53.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-9.975F, 16.625F, 33.25F, 1.0305F, 0.1582F, -0.2095F));

        ModelPartData _gltfNode_259_r1 = front.addChild("_gltfNode_259_r1", ModelPartBuilder.create().uv(522, 1272).cuboid(-19.113F, -101.4847F, -2.4748F, 13.0F, 117.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-9.975F, -9.975F, -13.3F, 1.1821F, -0.3711F, -0.0018F));

        ModelPartData _gltfNode_219_r1 = front.addChild("_gltfNode_219_r1", ModelPartBuilder.create().uv(476, 1156).cuboid(-6.9995F, -27.4177F, -2.5568F, 7.0F, 30.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(6.65F, 23.275F, 16.625F, 0.5564F, 0.1166F, -0.1848F));

        ModelPartData _gltfNode_221_r1 = front.addChild("_gltfNode_221_r1", ModelPartBuilder.create().uv(1044, 1309).cuboid(-6.6897F, -18.0202F, -1.0405F, 7.0F, 20.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.3298F, 0.4703F, -0.9239F));
        return TexturedModelData.of(modelData, 2048, 2048);
    }

    @Override
    public void setAngles(OliphauntEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(OliphauntAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, OliphauntAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
        headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

        float magicNumber = 0.017453292F;

        this.head.yaw = headYaw * magicNumber;
        this.head.pitch = headPitch * magicNumber;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        oliphaunt.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return oliphaunt;
    }
}
