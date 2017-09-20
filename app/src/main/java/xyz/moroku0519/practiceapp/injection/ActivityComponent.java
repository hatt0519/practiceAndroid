package xyz.moroku0519.practiceapp.injection;

import dagger.Component;
import xyz.moroku0519.practiceapp.MainActivity;

/**
 * Created by kazuki on 2017/09/17.
 */

@Component(modules = TestModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
