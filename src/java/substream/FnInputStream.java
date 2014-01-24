package substream;

import clojure.lang.IFn;
import java.io.InputStream;

public class FnInputStream extends InputStream
{
    private IFn readFunc;

    public FnInputStream(IFn readFunc)
    {
        this.readFunc = readFunc;
    }

    public int read()
    {
        return (int)readFunc.invoke();
    }
}
