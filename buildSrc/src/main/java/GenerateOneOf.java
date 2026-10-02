import freemarker.template.*;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Map;

public class GenerateOneOf extends DefaultTask {
  private @NotNull String template;
  private @NotNull String key;
  private @NotNull String dir;
  private int count;

  @Input
  public @NotNull String getTemplate() {
    return template;
  }

  public void setTemplate(@NotNull String template) {
    this.template = template;
  }

  @Input
  public @NotNull String getKey() {
    return key;
  }

  public void setKey(@NotNull String key) {
    this.key = key;
  }

  @Input
  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  @Input
  public @NotNull String getDir() {
    return dir;
  }

  public void setDir(@NotNull String dir) {
    this.dir = dir;
  }

  @TaskAction
  public void generate() {
    for (int i = 2; i <= count; i++) {
      final var filename = dir + "/src/main/java/dev/upwake/oneof/OneOf" + i + ".java";
      new File(filename).delete();
      try (var writer = new OutputStreamWriter(new FileOutputStream(filename))) {
        template().process(Map.of(key, i), writer);
      } catch (TemplateException | IOException e) {
        throw new GradleException("Failed to generate " + filename + " using " + template, e);
      }
    }
  }

  private @NotNull Template template() throws IOException {
    final var configuration = new Configuration(new Version(2, 3, 32));
    configuration.setDefaultEncoding("UTF-8");
    configuration.setLocale(Locale.US);
    configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    configuration.setDirectoryForTemplateLoading(new File(dir + "/templates"));
    return configuration.getTemplate(template);
  }
}