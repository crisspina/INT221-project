<template>
    <button class="py-3 px-5 font-semibold hover:bg-white hover:text-button"
    @click="$emit('click')" 
    :class="[buttonColor, textColor,borderRounded]"
    > 
        {{ buttonLabel }}
    </button>
</template>
<script>
export default {
    name: 'BaseButton',
    props: ['buttonLabel','buttonColor','textColor','borderRounded'],
    emits: ['click']
}
</script>

