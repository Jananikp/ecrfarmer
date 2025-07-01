<template>
  <div>
    <HeaderBar />
    <NavigationBar />
    <router-view />
  </div>
</template>

<script setup>
import HeaderBar from '@/components/HeaderBar.vue'
import NavigationBar from '@/components/NavigationBar.vue'
</script>
