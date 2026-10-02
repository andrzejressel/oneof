package dev.upwake.oneof;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

<#assign types_seq = [] />
<#list 1..oneof as i>
  <#assign types_seq = types_seq + ['T' + i] />
</#list>
<#assign types = '<' + types_seq?join(", ") + '>' />
public class OneOf${oneof}${types} {
<#list 1..<oneof + 1 as i>
  private final @Nullable T${i} value${i};
</#list>

<#list 1..<oneof + 1 as i>
  public static @NotNull ${types} OneOf${oneof}${types} of${i}(@NotNull T${i} value) {
    <#assign parameters = [] />
    <#list 1..oneof as i2>
        <#assign parameters = parameters + (i == i2)?then(['value'], ['null']) />
    </#list>
    return new OneOf${oneof}<>(${parameters?join(', ')});
  }

</#list>
  protected OneOf${oneof}(@Nullable T1 value1<#list 2..<oneof + 1 as i>,
                   @Nullable T${i} value${i}</#list>) {
<#list 1..<oneof + 1 as i>
    this.value${i} = value${i};
</#list>
  }
<#list 1..<oneof + 1 as i>

  public @Nullable T${i} _${i}() {
    return value${i};
  }
</#list>

  public void match(@NotNull Consumer<T1> consumer1<#list 2..<oneof + 1 as i>,
                    @NotNull Consumer<T${i}> consumer${i}</#list>) {
<#list 1..<oneof + 1 as i>
    if (value${i} != null) {
      consumer${i}.accept(value${i});
      return;
    }
</#list>
    throw new NoSuchElementException("None of the values are present");
  }

  public @NotNull <R> R fold(@NotNull Function<T1, R> function1<#list 2..<oneof + 1 as i>,
                             @NotNull Function<T${i}, R> function${i}</#list>) {
<#list 1..<oneof + 1 as i>
    if (value${i} != null) {
      return function${i}.apply(value${i});
    }
</#list>
    throw new NoSuchElementException("None of the values are present");
  }

<#macro replace_type_with_r index><${types_seq?map(t -> (t == 'T' + index)?then('R', t))?join(', ')}></#macro>
<#list 1..<oneof + 1 as i>
  public @NotNull <R> OneOf${oneof}<@replace_type_with_r index=i/> map${i}(@NotNull Function<T${i}, R> function) {
<#list 1..<oneof + 1 as i2>
    if (value${i2} != null) {
      return OneOf${oneof}.of${i2}(${(i == i2)?then('function.apply(value' + i + ')', 'value' + i2)});
    }
</#list>
    throw new NoSuchElementException("None of the values are present");
  }

</#list>
  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final OneOf${oneof}<${types_seq?map(_ -> '?')?join(', ')}> oneOf${oneof} = (OneOf${oneof}<${types_seq?map(_ -> '?')?join(', ')}>) o;
<#assign equals_seq = [] />
<#list 1..oneof as i>
  <#assign equals_seq = equals_seq + ['Objects.equals(value' + i + ', oneOf' + oneof + '.value' + i + ')'] />
</#list>
    return ${equals_seq?join('
        && ')};
  }

  @Override
  public int hashCode() {
<#assign hash_seq = [] />
<#list 1..oneof as i>
  <#assign hash_seq = hash_seq + ['value' + i] />
</#list>
    return Objects.hash(${hash_seq?join(', ')});
  }

  @Override
  public @NotNull String toString() {
<#list 1..<oneof + 1 as i>
    if (value${i} != null) {
      return "${i}of${oneof}{" + value${i} + '}';
    }
</#list>
    return "NoneOf${oneof}";
  }
}
