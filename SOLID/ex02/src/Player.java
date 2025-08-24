public class Player {
    private Decoder decoder = new Decoder();
    private UIRenderer uiRenderer = new UIRenderer();
    private FrameCache frameCache = new FrameCache();
    
    public void play(byte[] fileBytes) {
        // decode
        Frame frame = decoder.decode(fileBytes);
        // draw UI
        uiRenderer.render(fileBytes);
        // cache
        frameCache.cache(frame);
    }
}