package gregtechCH.tileentity.cores.motors;

/**
 * 会爆炸的 core 继承这个接口
 */
public interface IMTEC_CanExplode {
    boolean canExplode();
    void explode(boolean aInstant);
}
