package pl.andrzejressel.oneof;

import java.util.function.Function;

<#assign types_seq = [] />
<#list 1..oneof as i>
  <#assign types_seq = types_seq + ['T' + i] />
</#list>
<#assign variant_names = ["First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth"] />
sealed public interface OneOf${oneof}<${types_seq?join(", ")}> permits OneOf${oneof}.${variant_names[0]}<#list 1..<oneof as i>, OneOf${oneof}.${variant_names[i]}</#list> {
<#list 1..oneof as i>
    default <R> OneOf${oneof}<${types_seq?map(t -> (t == 'T' + i)?then('R', t))?join(", ")}> map${variant_names[i - 1]}(Function<? super T${i}, ? extends R> mapper) {
        return switch (this) {
<#list 1..oneof as i2>
            case ${variant_names[i2 - 1]}(var value) -> new ${variant_names[i2 - 1]}<>(${(i == i2)?then('mapper.apply(value)', 'value')});
</#list>
        };
    }

</#list>
    default <T> T fold(Function<? super T1, ? extends T> firstMapper<#list 2..oneof as i>, Function<? super T${i}, ? extends T> ${variant_names[i - 1]?uncap_first}Mapper</#list>) {
        return switch (this) {
<#list 1..oneof as i>
            case ${variant_names[i - 1]}(var value) -> ${variant_names[i - 1]?uncap_first}Mapper.apply(value);
</#list>
        };
    }

    @SuppressWarnings("unchecked")
    static <${types_seq?join(", ")}> OneOf${oneof}<${types_seq?join(", ")}> fromIndex(int index, Object obj) {
        return switch (index) {
<#list 1..oneof as i>
            case ${i - 1} -> new ${variant_names[i - 1]}<>((T${i}) obj);
</#list>
            default -> throw new IllegalArgumentException("Invalid index: " + index);
        };
    }

<#list 1..oneof as i>
    static <${types_seq?join(", ")}> OneOf${oneof}<${types_seq?join(", ")}> ${variant_names[i - 1]?uncap_first}(T${i} value) {
        return new ${variant_names[i - 1]}<>(value);
    }

</#list>
<#list 1..oneof as i>
    record ${variant_names[i - 1]}<<#list 1..oneof as i2><#if i2 gt 1>, </#if>A${i2}</#list>>(A${i} value) implements OneOf${oneof}<<#list 1..oneof as i2><#if i2 gt 1>, </#if>A${i2}</#list>> {
    }

</#list>
}
