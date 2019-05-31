package fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class Font_Roboto_medium extends android.support.v7.widget.AppCompatTextView {
    public Font_Roboto_medium(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Font_Roboto_medium(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Font_Roboto_medium(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Medium.ttf");
            setTypeface(tf);
        }
    }


}
