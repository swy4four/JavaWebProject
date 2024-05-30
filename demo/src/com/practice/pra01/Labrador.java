package com.practice.pra01;

/**
 * 拉布拉多 类 继承 Dogs
 * 最下层，后面没人继承
 *final  最终 断子绝孙了
 * 1.遗产没人继承，也不可能被继承————final 的类 他不可能被继承了
 *
 */
public final class Labrador extends Dogs{
    @Override
    //final 不能重写
    public boolean isGuideBlindness() {
        return true;
    }
}
