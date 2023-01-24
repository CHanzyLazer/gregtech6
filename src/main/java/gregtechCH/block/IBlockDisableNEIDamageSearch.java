package gregtechCH.block;

/**
 * @author CHanzy
 * 方块继承此类阻止 NEI 对其的 DamageSearch 过程
 * 实现 disableNEIDamageSearch 方法可以对同一个类的不同物品做区分
 */
public interface IBlockDisableNEIDamageSearch {
    boolean disableNEIDamageSearch();
}
